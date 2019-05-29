package com.ruoyi.web.controller.question;

import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.system.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/front")
public class FrontController extends BaseController {
    private String prefix = "front";

    @Autowired
    private IDeviceService deviceService;

    @GetMapping("/index")
    public String home() {
        return prefix + "/index";
    }

}
