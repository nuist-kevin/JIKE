package com.jikexueyuan.caiwen.action;

import com.jikexueyuan.caiwen.dto.UserDto;
import com.jikexueyuan.caiwen.entity.RoleName;
import com.jikexueyuan.caiwen.entity.User;
import com.jikexueyuan.caiwen.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import org.springframework.data.domain.Page;

/**
 * @author caiwen
 */
public class UserAction extends ActionSupport {

  @Autowired
  private UserService userService;
  private UserDto userDto = new UserDto();
  private User user;
  private Integer page;
  private Map<String, Object> jsonResult = new HashMap<>();

  public UserService getUserService() {
    return userService;
  }

  public void setUserService(UserService userService) {
    this.userService = userService;
  }


  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public Map<String, Object> getJsonResult() {
    return jsonResult;
  }

  public void setJsonResult(Map<String, Object> jsonResult) {
    this.jsonResult = jsonResult;
  }

  public UserDto getUserDto() {
    return userDto;
  }

  public void setUserDto(UserDto userDto) {
    this.userDto = userDto;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String register() throws Exception {
    return SUCCESS;
  }

  public String doRegister() throws Exception {
    user = new User();
    user = userDto.toUser(user);
    userService.addUser(user);
    return SUCCESS;
  }

  public String login() throws Exception {
    System.out.println("test");
    if (userService.validateUser(userDto.getUsername(), userDto.getPassword())) {
      user = userService.getUserByUsername(userDto.getUsername());
      ActionContext.getContext().getSession().put("userId", user.getUserId());
      if (user.getRole().getRoleName().equals(RoleName.ADMIN)) {
        return "maintain";
      } else {
        return "shopping";
      }
    } else {
      return ERROR;
    }
  }

  public String list() throws Exception {
    return SUCCESS;
  }

  public String pagedList() throws Exception {
    Page<User> queryResult = userService.pageQuery(page, 10);
    jsonResult.put("users", queryResult.getContent());
    jsonResult.put("totalPages", queryResult.getTotalPages());
    return SUCCESS;
  }

  public String add() throws Exception {
    return SUCCESS;
  }

  public String doAdd() throws Exception {
    return doRegister();
  }

  public String delete() throws Exception {
    userService.deleteUser(user.getUserId());
    jsonResult.put("success", 1);
    return SUCCESS;
  }

  public String edit() throws Exception {
    user = userService.getUserById(user.getUserId());
    BeanUtils.copyProperties(user, userDto, "orders", "shoppingCart");
    return SUCCESS;
  }

  public String doEdit() throws Exception {
    userService.updateUser(user);
    return SUCCESS;
  }

}
