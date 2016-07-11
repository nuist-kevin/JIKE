package com.jikexueyuan.caiwen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jikexueyuan.caiwen.db.ConnectionFactory;
import com.jikexueyuan.caiwen.domain.Poet;
import com.jikexueyuan.caiwen.domain.Poetry;

public class PoetryDao {

	public List<String> getPoetryTitlesByPoetName(String poetName) {
		Connection connection = ConnectionFactory.getInstance().getConnection();
		List<String> poetryTitleList = new ArrayList<>();
		String sql = "select t1.title from tang_poetry.poetries t1 "
				+ "join tang_poetry.poets t2 on t1.poet_id = t2.id " + " where t2.name = ? ";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try	{
			statement = connection.prepareStatement(sql);
			statement.setString(1, poetName);
			resultSet = statement.executeQuery();
				
			while (resultSet.next()) {
				poetryTitleList.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return poetryTitleList;
	}
	
	public List<Poetry>  getPoetries(String content, String title) {
		Connection connection = ConnectionFactory.getInstance().getConnection();
		List<Poetry> poetryTitleList = new ArrayList<>();
		String sql = "select t1.title, t1.content, t2.name from tang_poetry.poetries t1 "
				+ "join tang_poetry.poets t2 on t1.poet_id = t2.id where 1=1 ";
				if (content != null) {
					sql += " and  t1.content like ? ";
				}
				if (title != null) {
					sql += " and  t1.title like ? ";
				}
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try	{
			statement = connection.prepareStatement(sql);
			if (content != null) {
				statement.setString(1, "%" + content + "%");
			}
			if (title != null) {
				statement.setString(1, "%" + title + "%");
			}
			resultSet = statement.executeQuery();
				
			while (resultSet.next()) {
				Poetry poetry = new Poetry();
				poetry.setTitle(resultSet.getString(1));
				poetry.setContent(resultSet.getString(2));
				Poet poet = new Poet();
				poet.setName(resultSet.getString(3));
				poetry.setPoet(poet);
				poetryTitleList.add(poetry);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return poetryTitleList;
	}
}
