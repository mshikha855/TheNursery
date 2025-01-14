package com.thenurserysystem.service;

import java.util.List;

import com.thenurserysystem.bean.Question;

public interface QuestionService {

	int saveQuestionDetails(Question q);

	List<Question> fetchQuestionDetails();

	int saveAnswerDetails(String questionid, Question q);

	List<Question> fetchAvailableQuestionDetails();

	int deleteQuestionDetails(String queid);

}
