package com.jikexueyuan.caiwen.action;

import com.jikexueyuan.caiwen.domain.Vip;
import com.jikexueyuan.caiwen.service.VipService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class VipAction extends ActionSupport{
    private Integer vid;
    private Vip vip;
    private VipService vipService;

    private Map<String, Object> pageData = new HashMap<>();
    private Integer page;
    private Integer id;
    private String name;
    private Integer fromAge;
    private Integer toAge;
    private String profession;
    private Date fromDate;
    private Date toDate;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFromAge() {
        return fromAge;
    }

    public void setFromAge(Integer fromAge) {
        this.fromAge = fromAge;
    }

    public Integer getToAge() {
        return toAge;
    }

    public void setToAge(Integer toAge) {
        this.toAge = toAge;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Map<String, Object> getPageData() {
        return pageData;
    }

    public void setPageData(Map<String, Object> pageData) {
        this.pageData = pageData;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Vip getVip() {
        return vip;
    }

    public void setVip(Vip vip) {
        this.vip = vip;
    }

    public VipService getVipService() {
        return vipService;
    }

    @Autowired
    public void setVipService(VipService vipService) {
        this.vipService = vipService;
    }

    public String list() throws Exception {
        return SUCCESS;
    }

    /**
     * 列表数据异步动态查询方法，借助struts-json插件，result的type为json
     * @return json格式的查询结果，json格式为{dataList:[……], totalPages: x}
     * @throws Exception
     */
    public String jsonList() throws Exception {
        Page<Vip> VipPage;
        VipPage = vipService.query(id, name, fromAge, toAge, profession, fromDate, toDate, page);
        pageData.put("dataList",VipPage.getContent());
        pageData.put("totalPages",VipPage.getTotalPages());
        return SUCCESS;
    }

    public String addView() throws Exception {
        return SUCCESS;
    }

    public String doAdd() throws Exception {
        vipService.add(vip);
        return SUCCESS;
    }



    public String view() throws  Exception {
        setVip(vipService.get(vid));
        return SUCCESS;
    }

    public String editView() throws  Exception {
        setVip(vipService.get(vid));
        return SUCCESS;
    }

    public String doEdit() throws  Exception {
        vip.setId(vid);
        vip = vipService.update(vip);
        return SUCCESS;
    }

    public String delete() throws  Exception {
        vipService.delete(vid);
        return SUCCESS;
    }
}
