package com.jikexueyuan.caiwen.action;

import com.jikexueyuan.caiwen.domain.Vip;
import com.jikexueyuan.caiwen.service.impl.jpa.VipService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by caiwen on 2016/7/24.
 */
public class VipAction extends ActionSupport{
    private Integer id;
    private Vip vip;
    private List<Vip> vips;
    private VipService vipService;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Vip getVip() {
        return vip;
    }

    public void setVip(Vip vip) {
        this.vip = vip;
    }

    public List<Vip> getVips() {
        return vips;
    }

    public void setVips(List<Vip> vips) {
        this.vips = vips;
    }

    public VipService getVipService() {
        return vipService;
    }

    @Autowired
    public void setVipService(VipService vipService) {
        this.vipService = vipService;
    }

    public String addView() throws Exception {
        return SUCCESS;
    }

    public String doAdd() throws Exception {
        vipService.add(vip);
        return SUCCESS;
    }

    public String list() throws Exception {
        vips = vipService.findAll();
        return SUCCESS;
    }

    public String view() throws  Exception {
        setVip(vipService.get(id));
        return SUCCESS;
    }

    public String editView() throws  Exception {
        setVip(vipService.get(id));
        return SUCCESS;
    }

    public String doEdit() throws  Exception {
        vip.setId(id);
        vip = vipService.update(vip);
        return SUCCESS;
    }

    public String delete() throws  Exception {
        vipService.delete(id);
        return SUCCESS;
    }
}
