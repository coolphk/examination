package com.ruoyi.model;

import com.ruoyi.common.base.BaseEntity;

/**
 * 考题表 sys_question
 * 
 * @author ruoyi
 * @date 2019-04-17
 */
public class QuestionModel extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private Integer questionId;
	/** 考题 */
	private String questionTitle;
	/** 正确答案 */
	private String rightAnswer;
	/** 考题顺序 */
	private Integer orderNum;


	/** 题目答案 */
	private String answer;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}




	public void setQuestionId(Integer questionId) 
	{
		this.questionId = questionId;
	}

	public Integer getQuestionId() 
	{
		return questionId;
	}
	public void setQuestionTitle(String questionTitle) 
	{
		this.questionTitle = questionTitle;
	}

	public String getQuestionTitle() 
	{
		return questionTitle;
	}
	public void setRightAnswer(String rightAnswer) 
	{
		this.rightAnswer = rightAnswer;
	}

	public String getRightAnswer() 
	{
		return rightAnswer;
	}
	public void setOrderNum(Integer orderNum) 
	{
		this.orderNum = orderNum;
	}

	public Integer getOrderNum() 
	{
		return orderNum;
	}



}
