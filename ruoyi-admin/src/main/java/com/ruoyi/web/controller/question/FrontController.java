package com.ruoyi.web.controller.question;

import com.ruoyi.framework.web.base.BaseController;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Controller
@RequestMapping("/front")
public class FrontController extends BaseController {
    private String prefix = "front";

    @GetMapping("/home")
    public String home() {
        return prefix+"/home";
    }

    @GetMapping("/weather")
    public String Weather() {
        return prefix+"/weather";
    }


}
