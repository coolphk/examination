package com.ruoyi.web.controller.question;

import java.util.List;

import com.ruoyi.generator.domain.TableInfo;
import com.ruoyi.model.QuestionModel;
import com.ruoyi.system.domain.Question;
import com.ruoyi.system.service.IDeviceService;
import com.ruoyi.system.service.IQuestionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 考题 信息操作处理
 *
 * @author ruoyi
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/examination")
public class QuestionController extends BaseController {
    private String prefix = "examination";

    @Autowired
    private IQuestionService questionService;

    @RequiresPermissions("web:examination:view")
    @GetMapping("/question")
    public String question() {
        return prefix + "/question";
    }

    /**
     * 查询考题列表
     */
    @RequiresPermissions("web:examination:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Question question) {
        startPage();
        List<Question> list = questionService.selectQuestionList(question);
        return getDataTable(list);
    }


    /**
     * 导出考题列表
     */
    @RequiresPermissions("web:examination:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Question question) {
        List<Question> list = questionService.selectQuestionList(question);
        ExcelUtil<Question> util = new ExcelUtil<Question>(Question.class);
        return util.exportExcel(list, "question");
    }

    /**
     * 新增考题
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存考题
     */
    @RequiresPermissions("web:examination:add")
    @Log(title = "考题", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Question question) {
        System.out.println(question);
//		return null;
        return toAjax(questionService.insertQuestion(question));
    }

    /**
     * 修改考题
     */
    @GetMapping("/edit/{questionId}")
    public String edit(@PathVariable("questionId") Integer questionId, ModelMap mmap) {
        Question question = questionService.selectQuestionById(questionId);
        mmap.put("question", question);
        return prefix + "/edit";
    }

    /**
     * 修改保存考题
     */
    @RequiresPermissions("web:examination:edit")
    @Log(title = "考题", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Question question) {
        return toAjax(questionService.updateQuestion(question));
    }

    /**
     * 删除考题
     */
    @RequiresPermissions("web:examination:remove")
    @Log(title = "考题", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(questionService.deleteQuestionByIds(ids));
    }


    @GetMapping("selectrandom")
    @ResponseBody
    public TableDataInfo selectRandom() {
        return getDataTable(questionService.selectQuestionRandom());
    }
}
