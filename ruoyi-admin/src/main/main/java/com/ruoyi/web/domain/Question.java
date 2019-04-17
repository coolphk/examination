package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 考题表 sys_question
 * 
 * @author ruoyi
 * @date 2019-04-16
 */
public class Question extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer questionId;
	/**  */
	private String questionTitle;
	/**  */
	private Integer answer;
	/**  */
	private String orderNum;

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
	public void setAnswer(Integer answer) 
	{
		this.answer = answer;
	}

	public Integer getAnswer() 
	{
		return answer;
	}
	public void setOrderNum(String orderNum) 
	{
		this.orderNum = orderNum;
	}

	public String getOrderNum() 
	{
		return orderNum;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("questionId", getQuestionId())
            .append("questionTitle", getQuestionTitle())
            .append("answer", getAnswer())
            .append("orderNum", getOrderNum())
            .toString();
    }
}
