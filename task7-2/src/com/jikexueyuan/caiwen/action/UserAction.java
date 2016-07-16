package com.jikexueyuan.caiwen.action;

import java.util.ArrayList;
import java.util.List;

import com.jikexueyuan.caiwen.domain.User;
import com.jikexueyuan.caiwen.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

    private List<User> users;
    private User user;
    private UserService userService = new UserService();
    private Integer userId;

    private int page;
    private Long pageNum;
    private Long totalCount;
    private List<Long> indexList;

    public List<Long> getIndexList() {
        return indexList;
    }

    public void setIndexList(List<Long> indexList) {
        this.indexList = indexList;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getPageNum() {
        return pageNum;
    }

    public void setPageNum(Long pageNum) {
        this.pageNum = pageNum;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    private static final long serialVersionUID = -77981250535684115L;

    public String add() throws Exception {
        userService.create(getUser());
        return SUCCESS;
    }

    public String delete() throws Exception {
        userService.delete(getUserId());
        return SUCCESS;
    }

    public String edit() throws Exception {
        if (getUserId() != null) {
            setUser(userService.get(getUserId()));
        } else {
            ActionContext ctx = ActionContext.getContext();
            Integer sessionUserId = (Integer) ctx.getSession().get("userId");
            setUser(userService.get(sessionUserId));
        }
        return SUCCESS;
    }

    public String doEdit() throws Exception {
        getUser().setId(getUserId());
        userService.edit(getUser());
        return SUCCESS;
    }

    public String view() throws Exception {
        if (getUserId() != null) {
            setUser(userService.get(getUserId()));
        } else {
            ActionContext ctx = ActionContext.getContext();
            Integer sessionUserId = (Integer) ctx.getSession().get("userId");
            setUser(userService.get(sessionUserId));
        }
        return SUCCESS;
    }

    public String list() throws Exception {
        setTotalCount(userService.getTotalCount());
        setPageNum(totalCount % 10 == 0 ? totalCount / 10 : (totalCount / 10 + 1));
        indexList = new ArrayList<>();
        for (Long i = 1L; i <= getPageNum(); i++) {
            indexList.add(i);
        }
        setPage(getPage());
        setUsers(userService.findBypage(getPage()));
        return SUCCESS;
    }


    //todo 用户搜索
}
