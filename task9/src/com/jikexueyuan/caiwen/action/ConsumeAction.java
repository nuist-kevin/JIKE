package com.jikexueyuan.caiwen.action;

import com.jikexueyuan.caiwen.domain.Consume;
import com.jikexueyuan.caiwen.service.ConsumeService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.Map;

public class ConsumeAction extends ActionSupport {

    @Autowired
    private ConsumeService consumeService;
    private Consume consume;

    /**
     * 列表查询所需的几个属性
     */
    private Map<String, Object> pageData = new HashMap<>();
    private Integer page;
    private Integer vipId;
    private String name;

    public Map<String, Object> getPageData() {
        return pageData;
    }

    public void setPageData(Map<String, Object> pageData) {
        this.pageData = pageData;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getVipId() {
        return vipId;
    }

    public void setVipId(Integer vipId) {
        this.vipId = vipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConsumeService getConsumeService() {
        return consumeService;
    }

    public void setConsumeService(ConsumeService consumeService) {
        this.consumeService = consumeService;
    }

    public Consume getConsume() {
        return consume;
    }

    public void setConsume(Consume consume) {
        this.consume = consume;
    }

    public String addView() throws Exception {
        return SUCCESS;
    }

    public String doAdd() throws Exception {
        consume = consumeService.add(consume);
        return SUCCESS;
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
        Page<Consume> consumePage = consumeService.query(vipId, name, page);
        pageData.put("totalPages", consumePage.getTotalPages());
        pageData.put("dataList", consumePage.getContent());
        return SUCCESS;
    }
}
