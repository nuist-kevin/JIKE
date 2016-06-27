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

	public List<Poetry> getPoetries(String searchOption, String searchValue) {
		Connection connection = ConnectionFactory.getInstance().getConnection();
		List<Poetry> poetryList = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "select t1.id, t1.title, t1.content, t2.id, t2.name from tang_poetry.poetries t1 "
				+ "join tang_poetry.poets t2 on t1.poet_id = t2.id where 1=1 ";
		if ("1".equals(searchOption)) {
			sql += " and  t2.name = ? ";
		}
		if ("2".equals(searchOption)) {
			sql += " and  t1.title like ? ";
		}
		if ("3".equals(searchOption)) {
			sql += " and  t1.content like ? ";
		}
		try {
			statement = connection.prepareStatement(sql);
			if ("1".equals(searchOption)) {
				statement.setString(1, searchValue);
			}
			if ("2".equals(searchOption)) {
				statement.setString(1, "%" + searchValue + "%");
			}
			if ("3".equals(searchOption)) {
				statement.setString(1, "%" + searchValue + "%");
			}
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Poetry poetry = new Poetry();
				poetry.setId(resultSet.getInt("t1.id"));
				poetry.setTitle(resultSet.getString("t1.title"));
				poetry.setContent(resultSet.getString("t1.content"));
				Poet poet = new Poet();
				poet.setId(resultSet.getInt("t2.id"));
				poet.setName(resultSet.getString("t2.name"));
				poetry.setPoet(poet);
				poetryList.add(poetry);
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
		return poetryList;
	}
}
