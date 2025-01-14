package com.thenurserysystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.thenurserysystem.bean.Product;
import com.thenurserysystem.bean.Question;
import com.thenurserysystem.dao.QuestionDao;

public class QuestionDaoImpl implements QuestionDao {

	@Override
	public int insertQuestionDetails(Connection connection, Question q) throws SQLException {
		int ans = 0;
		String insertQuery = "insert into question(que_details,user_id,que_status) values(?,?,0)";
		try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
			
			ps.setString(1,q.getQuestionDetails());
			ps.setInt(2, q.getUserId());
			
			ans = ps.executeUpdate();
		}
		return ans;
	}

	@Override
	public List<Question> selectQuestionDetails(Connection connection) throws SQLException {
		
		List<Question> questionList=new ArrayList<>();
		try(PreparedStatement ps=connection.prepareStatement("select * from question");
				ResultSet resultset=ps.executeQuery()){

			while(resultset.next())
			{
					Question question=new Question();
					question.setGardenerId(resultset.getInt("gardener_id"));
					question.setQuestionId(resultset.getInt("que_id"));
					question.setQuestionDetails(resultset.getString("que_details"));
					question.setAnswer(resultset.getString("answer"));
					question.setUserId(resultset.getInt("user_id"));
					questionList.add(question);
			}	
			
		}
		return questionList;
	}

	@Override
	public int insertAnswerDetails(Connection connection,int questionid, Question q) throws SQLException {
		int ans = 0;
		String insertQuery = "update question set answer=?,que_status=1,gardener_id=? where que_id=? ";
		
		
		try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
			
			ps.setString(1,q.getAnswer());
			
			ps.setInt(2, q.getGardenerId());
			
			ps.setInt(3, questionid);
			
			ans = ps.executeUpdate();
		}
		return ans;
	}

	@Override
	public List<Question> selectAvailableQuestionDetails(Connection connection) throws SQLException {
		List<Question> questionList=new ArrayList<>();
		try(PreparedStatement ps=connection.prepareStatement("select * from question where que_status=0");
				ResultSet resultset=ps.executeQuery()){

			while(resultset.next())
			{
					Question question=new Question();
					question.setQuestionId(resultset.getInt("que_id"));
					question.setQuestionDetails(resultset.getString("que_details"));
					question.setAnswer(resultset.getString("answer"));
					question.setUserId(resultset.getInt("user_id"));
					questionList.add(question);
			}	
			
		}
		return questionList;

	}

	@Override
	public int deleteQuestionDetails(Connection connection, int queid) throws SQLException {
		int ans = 0;
		String insertQuery = "delete from question where que_id=?";
		try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
			
		ps.setInt(1,queid);
			
			ans = ps.executeUpdate();
		}
		return ans;
	}
}
