package com.ruoyi.system.service;

import com.ruoyi.system.domain.Question;

import java.util.List;

/**
 * 考题 服务层
 * 
 * @author ruoyi
 * @date 2019-04-17
 */
public interface IQuestionService 
{
	/**
     * 查询考题信息
     * 
     * @param questionId 考题ID
     * @return 考题信息
     */
	public Question selectQuestionById(Integer questionId);
	
	/**
     * 查询考题列表
     * 
     * @param question 考题信息
     * @return 考题集合
     */
	public List<Question> selectQuestionList(Question question);
	
	/**
     * 新增考题
     * 
     * @param question 考题信息
     * @return 结果
     */
	public int insertQuestion(Question question);
	
	/**
     * 修改考题
     * 
     * @param question 考题信息
     * @return 结果
     */
	public int updateQuestion(Question question);
		
	/**
     * 删除考题信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteQuestionByIds(String ids);


	/**
	 * 随机查找题目
	 */
	public List<Question> selectQuestionRandom();


}
