package com.thenurserysystem.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.thenurserysystem.bean.Question;

public interface QuestionDao {

	int insertQuestionDetails(Connection connection, Question q) throws SQLException;

	List<Question> selectQuestionDetails(Connection connection) throws SQLException;

	int insertAnswerDetails(Connection connection, int questionid, Question q) throws SQLException;

	List<Question> selectAvailableQuestionDetails(Connection connection) throws SQLException;

	int deleteQuestionDetails(Connection connection, int parseInt) throws SQLException;

}
