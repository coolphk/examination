package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.Question;
import com.ruoyi.system.mapper.QuestionMapper;
import com.ruoyi.system.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.support.Convert;

/**
 * 考题 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-17
 */
@Service
public class QuestionServiceImpl implements IQuestionService
{
	@Autowired
	private QuestionMapper questionMapper;

	/**
     * 查询考题信息
     * 
     * @param questionId 考题ID
     * @return 考题信息
     */
    @Override
	public Question selectQuestionById(Integer questionId)
	{
	    return questionMapper.selectQuestionById(questionId);
	}
	
	/**
     * 查询考题列表
     * 
     * @param question 考题信息
     * @return 考题集合
     */
	@Override
	public List<Question> selectQuestionList(Question question)
	{
	    return questionMapper.selectQuestionList(question);
	}
	
    /**
     * 新增考题
     * 
     * @param question 考题信息
     * @return 结果
     */
	@Override
	public int insertQuestion(Question question)
	{
	    return questionMapper.insertQuestion(question);
	}
	
	/**
     * 修改考题
     * 
     * @param question 考题信息
     * @return 结果
     */
	@Override
	public int updateQuestion(Question question)
	{
	    return questionMapper.updateQuestion(question);
	}

	/**
     * 删除考题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteQuestionByIds(String ids)
	{
		return questionMapper.deleteQuestionByIds(Convert.toStrArray(ids));
	}
	
}
