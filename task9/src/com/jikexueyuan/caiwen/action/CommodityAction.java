package com.jikexueyuan.caiwen.action;

import com.jikexueyuan.caiwen.domain.Commodity;
import com.jikexueyuan.caiwen.service.impl.jpa.CommodityService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by caiwen on 2016/7/24.
 * 商品Action类，用于商品添加和查询
 */
public class CommodityAction extends ActionSupport {

    private CommodityService commodityService;
    private Commodity commodity;
    //列表查看请求的页码
    private Integer page;
    //列表查看页所需的总页数
    private Long totalPages;
    //用于响应json格式列表请求
    private Map<String, Object> pageData;

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

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

    public CommodityService getCommodityService() {
        return commodityService;
    }

    @Autowired
    public void setCommodityService(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    /**
     * 添加页面处理方法
     * @return
     * @throws Exception
     */
    public String addView() throws Exception {
        return SUCCESS;
    }

    /**
     * 添加商品请求处理方法
     * @return
     * @throws Exception
     */
    public String doAdd() throws Exception {
        commodityService.add(commodity);
        return SUCCESS;
    }

    /**
     * 列表页处理方法
     * @return
     * @throws Exception
     */
    public String list() throws Exception {
        Long totalCount = commodityService.totalCount();
        totalPages = totalCount%5 > 0 ? totalCount/5 : totalCount/5 + 1;
        return SUCCESS;
    }

    public String jsonList() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        Page<Commodity> commodityPage;
        if (page == null) {
            commodityPage = commodityService.listByPage(0);
        } else {
            commodityPage = commodityService.listByPage(getPage()-1);
        }
        map.put("commodityList",commodityPage.getContent());
        setPageData(map);
        return SUCCESS;
    }
}
