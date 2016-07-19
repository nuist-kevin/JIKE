package com.jikexueyuan.caiwen.action;

import java.util.List;

import com.jikexueyuan.caiwen.domain.Poetry;
import com.jikexueyuan.caiwen.service.PoetryService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import org.springframework.beans.factory.annotation.Autowired;

public class PoetryAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Autowired
	private PoetryService poetryService;

	private String searchOption;
	private String searchValue;
	List<Poetry> poetryList;

	public String getSearchOption() {
		return searchOption;
	}
	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}

	public String getSearchValue() {
		return searchValue;
	}
	@FieldExpressionValidator(expression = "searchValue != ''",message = "请填写搜索项")
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	public List<Poetry> getPoetryList() {
		return poetryList;
	}
	public void setPoetryList(List<Poetry> poetryList) {
		this.poetryList = poetryList;
	}

	public String submit() throws Exception {
		//根据作者精确搜索
		if ("1".equals(searchOption)) {
			poetryList = poetryService.getPoetriesByPoetName(searchValue);
		}
		//根据诗名模糊搜索
		if ("2".equals(searchOption)) {
			poetryList = poetryService.getPoetriesBytitle(searchValue);
		}
		//根据名句模糊搜索
		if ("3".equals(searchOption)) {
			poetryList = poetryService.getPoetriesByContent(searchValue);
		}
		return SUCCESS;
	}

}
