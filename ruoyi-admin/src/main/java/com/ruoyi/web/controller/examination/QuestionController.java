package com.ruoyi.web.controller.examination;

import com.ruoyi.framework.web.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/examination")
public class QuestionController {

    private String prefix = "examination/";

    @GetMapping("/create")
    public String createQuestion() {
        return prefix + "createquestion";
    }
}
