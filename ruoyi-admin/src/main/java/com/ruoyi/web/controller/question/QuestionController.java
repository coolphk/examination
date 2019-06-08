package com.ruoyi.web.controller.question;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.config.ServerConfig;
import com.ruoyi.framework.util.FileUploadUtils;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.system.domain.Question;
import com.ruoyi.system.service.IQuestionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

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
    public static final String UPLOAD_PATH = "/profile/upload/";

    @Autowired
    private IQuestionService questionService;
    @Autowired
    private ServerConfig serverConfig;

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


    @GetMapping("/selectrandom")
    @ResponseBody
    public TableDataInfo selectRandom() {
        return getDataTable(questionService.selectQuestionRandom());
    }

    @GetMapping("/ueditor")
    public String UEditor() {
        return prefix + "/ueditor";
    }

    @GetMapping("/ueditor/config")
    @ResponseBody
    public String ueditorConfig(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        System.out.println(System.getProperty("user.dir")"/");
        Resource resource = new ClassPathResource("static/config.json");
        File file = resource.getFile();

//        File file = new File("./config.json");
        BufferedReader reader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
//                System.out.println("line " + line + ": " + tempString);
                stringBuilder.append(tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return stringBuilder.toString();
    }

    @PostMapping("/uploadimage")
    @ResponseBody
    public AjaxResult uploadImageData(MultipartHttpServletRequest mRequest) {
//        UeditorImage msg = uploadFile(request);
        try {
            // 上传文件路径
            String filePath = Global.getUploadPath();
            // 上传并返回新文件名称
            MultipartFile  file = mRequest.getFile("upfile");
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + UPLOAD_PATH + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("state", "SUCCESS");
            ajax.put("url", url);
            ajax.put("original", file.getOriginalFilename());
            ajax.put("title", file.getOriginalFilename());
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    public class UeditorImage {
        private String state;
        private String url;
        private String title;
        private String original;

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getOriginal() {
            return original;
        }

        public void setOriginal(String original) {
            this.original = original;
        }


    }

}
