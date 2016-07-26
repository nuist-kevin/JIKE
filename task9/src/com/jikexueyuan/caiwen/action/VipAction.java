package com.jikexueyuan.caiwen.action;

import com.google.gson.Gson;
import com.jikexueyuan.caiwen.domain.Vip;
import com.jikexueyuan.caiwen.service.impl.jpa.VipService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * Created by caiwen on 2016/7/24.
 */
public class VipAction extends ActionSupport{
    private Integer vid;
    private Vip vip;
    private List<Vip> vips;
    private VipService vipService;

    private InputStream inputStream;

    public InputStream getResult() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
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

    public String jsonList() throws Exception {
        vips = vipService.findAll();
        Gson gson = new Gson();
        inputStream = new ByteArrayInputStream(gson.toJson(vips).getBytes("UTF-8"));
        return "json";
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
