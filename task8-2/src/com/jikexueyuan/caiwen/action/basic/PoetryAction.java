package com.jikexueyuan.caiwen.action.basic;

import java.util.List;

import com.jikexueyuan.caiwen.dao.PoetryDao;
import com.jikexueyuan.caiwen.domain.Poetry;
import com.jikexueyuan.caiwen.service.PoetService;
import com.jikexueyuan.caiwen.service.PoetryService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import org.springframework.beans.factory.annotation.Autowired;

public class PoetryAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Autowired
	private PoetryService poetryService;
	@Autowired
	private PoetService poetService;

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
//		if (searchOption != null && searchValue != null && !("".equals(searchValue)) ) {
//			poetryList = poetryDao.getPoetries(searchOption, searchValue);
//		}
//		poetryList = poetryService.getPoetriesBytitle(searchValue);

		poetryList = poetService.getPoetriesByPoetName(searchValue);
		return SUCCESS;	}

	public String input() throws Exception {
		return INPUT;
	}
//	public String execute() throws Exception {
//		if (getSearchOption() != null && getSearchValue() != null && !("".equals(getSearchValue())) ) {
//			poetryList = poetryDao.getPoetries(getSearchOption(), getSearchValue());
//		}
//		return super.execute();
//	}
//
//	public String search() {
//		if (searchOption != null && searchValue != null && !("".equals(searchValue)) ) {
//			poetryList = poetryDao.getPoetries(searchOption, searchValue);
//		}
//		return SUCCESS;
//	}

}
