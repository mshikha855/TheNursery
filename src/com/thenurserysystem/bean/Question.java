package com.thenurserysystem.bean;

public class Question {
	
	public int questionId;
	public String questionDetails;
	public int userId;
	public int gardenerId;
	public Boolean status;
	public String answer;
	
	public Question(int questionId, String questionDetails) {
		this.questionId = questionId;
		this.questionDetails = questionDetails;
	}
	
	public Question() {}

	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionDetails() {
		return questionDetails;
	}
	public void setQuestionDetails(String questionDetails) {
		this.questionDetails = questionDetails;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGardenerId() {
		return gardenerId;
	}
	public void setGardenerId(int gardenerId) {
		this.gardenerId = gardenerId;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	

}
