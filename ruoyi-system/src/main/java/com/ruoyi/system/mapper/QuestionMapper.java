package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Question;

import java.util.List;

/**
 * 考题 数据层
 *
 * @author ruoyi
 * @date 2019-04-16
 */
public interface QuestionMapper {
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
     * 删除考题
     *
     * @param questionId 考题ID
     * @return 结果
     */
    public int deleteQuestionById(Integer questionId);

    /**
     * 批量删除考题
     *
     * @param questionIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteQuestionByIds(String[] questionIds);


    /***
     * 随机查找考题
     *
     *
     * */
    public List<Question> selectQuestionRandom();

}