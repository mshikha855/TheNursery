package com.thenurserysystem.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thenurserysystem.bean.Product;
import com.thenurserysystem.bean.Question;
import com.thenurserysystem.dao.QuestionDao;
import com.thenurserysystem.dao.impl.QuestionDaoImpl;
import com.thenurserysystem.service.QuestionService;

public class QuestionServiceImpl implements QuestionService {

	QuestionDao qd=new QuestionDaoImpl();
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nurseryschema?autoReconnect=true&useSSL=false", "root",
					"root@12345");
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int saveQuestionDetails(Question q) {
		int ans = 0;
		try (Connection connection = getConnection()) {
			
			ans = qd.insertQuestionDetails(connection, q);
			
			System.out.println(ans);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;

	}

	@Override
	public List<Question> fetchQuestionDetails() {
		List<Question> questionList=new ArrayList<>();
		
		try(Connection connection=getConnection();)
		{
			questionList=qd.selectQuestionDetails(connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return questionList;
	}

	@Override
	public int saveAnswerDetails(String questionid,Question q) {
		int ans = 0;
		try (Connection connection = getConnection()) {
			
			ans = qd.insertAnswerDetails(connection,Integer.parseInt(questionid), q);
			
			System.out.println(ans);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;


	}

	@Override
	public List<Question> fetchAvailableQuestionDetails() {
		
		List<Question> questionList=new ArrayList<>();
		
		try(Connection connection=getConnection();)
		{
			questionList=qd.selectAvailableQuestionDetails(connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return questionList;
	}

	@Override
	public int deleteQuestionDetails(String queid) {
		int ans = 0;
		try (Connection connection = getConnection()) {
			
			ans = qd.deleteQuestionDetails(connection, Integer.parseInt(queid));
			
			System.out.println(ans);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
		
	}
}
