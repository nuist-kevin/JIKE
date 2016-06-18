package com.jikexueyuan.caiwen.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jikexueyuan.caiwen.dao.PoetryDao;
import com.jikexueyuan.caiwen.domain.Poetry;

import net.sf.json.JSONObject;

public class PoetrySearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PoetryDao poetryDao = new PoetryDao();
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchOption = request.getParameter("searchOption");
		String searchValue = request.getParameter("searchValue");
		
		if (searchOption != null && searchValue != null) {
			if ("1".equals(searchOption)) {
				request.removeAttribute("titleLIst");
				List<String> titleList = new ArrayList<>();
				titleList = poetryDao.getPoetryTitlesByPoetName(searchValue);
				request.setAttribute("titleLIst", titleList);
				
				JSONObject jsonObjcect = new JSONObject();
				jsonObjcect.put("titleList", titleList);
				response.setContentType("text/json"); 
				response.getWriter().write(jsonObjcect.toString());
			} else if ("2".equals(searchOption)) {
				List<Poetry> poetList = poetryDao.getPoetries(null,searchValue);
				returnJson(request, response,"poetList",poetList);
			}
				else {
				List<Poetry> poetList = poetryDao.getPoetries(searchValue, null);
				returnJson(request, response,"poetList",poetList);
			}
			
		}

	}

	private void returnJson(HttpServletRequest request, HttpServletResponse response, String attributeNmae, List<Poetry> poetList)
			throws IOException {
		request.removeAttribute(attributeNmae);
		request.setAttribute(attributeNmae, poetList);
		JSONObject jsonObjcect = new JSONObject();
		jsonObjcect.put(attributeNmae, poetList);
		response.setContentType("text/json"); 
		response.getWriter().write(jsonObjcect.toString());
	}

}
