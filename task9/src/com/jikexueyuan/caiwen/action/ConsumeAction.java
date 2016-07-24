package com.jikexueyuan.caiwen.action;

import com.jikexueyuan.caiwen.domain.Consume;
import com.jikexueyuan.caiwen.service.impl.jpa.ConsumeService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by caiwen on 2016/7/24.
 */
public class ConsumeAction extends ActionSupport {

    @Autowired
    private ConsumeService consumeService;
    private Consume consume;
    private List<Consume> consumes;

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

    public List<Consume> getConsumes() {
        return consumes;
    }

    public void setConsumes(List<Consume> consumes) {
        this.consumes = consumes;
    }

    public String addView() throws Exception {
        return SUCCESS;
    }

    public String doAdd() throws Exception {
        consume = consumeService.add(consume);
        return SUCCESS;
    }

    public String list() throws Exception {
        consumes = consumeService.findAll();
        return SUCCESS;
    }
}
