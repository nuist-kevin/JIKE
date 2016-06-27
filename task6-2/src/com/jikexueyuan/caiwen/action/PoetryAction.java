package com.jikexueyuan.caiwen.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.ActionSupport;

import com.jikexueyuan.caiwen.dao.PoetryDao;
import com.jikexueyuan.caiwen.domain.Poetry;

public class PoetryAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String searchOption;
	private String searchValue;
	private PoetryDao poetryDao = new PoetryDao();
	private Map<String, List<Poetry>> poetryJson = new HashMap<>();;

	public String getSearchOption() {
		return searchOption;
	}

	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public Map<String, List<Poetry>> getPoetryJson() {
		return poetryJson;
	}

	public void setPoetryJson(Map<String, List<Poetry>> poetryJson) {
		this.poetryJson = poetryJson;
	}

	public String execute() {
		return INPUT;
	}

	public String returnJson() {
		List<Poetry> poetryList = poetryDao.getPoetries(searchOption, searchValue);
		poetryJson.put("poetryList", poetryList);
		return SUCCESS;

	}
}
