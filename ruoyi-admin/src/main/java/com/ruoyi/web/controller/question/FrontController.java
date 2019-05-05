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
    public String Home(HttpServletRequest request, HttpServletResponse response) {
        return prefix+"/home";
    }
    /*public void Home(HttpServletRequest request, HttpServletResponse response) {
        try {
            URL url = new URL("https://apip.weatherdt.com/h5.html?id=WA4qyG3njy");
            URLConnection URLconnection = url.openConnection();
            HttpURLConnection httpConnection = (HttpURLConnection) URLconnection;
            httpConnection.setRequestMethod("GET");
//            httpConnection.setRequestProperty("User-Agent","Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Mobile Safari/537.36");
//            httpConnection.setInstanceFollowRedirects(false);
            int responseCode = httpConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream in = httpConnection.getInputStream();
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader bufr = new BufferedReader(isr);
                String str;
                response.setHeader("Content-Type","text/html;charset=utf-8");
                while ((str = bufr.readLine()) != null) {
                    if(str.contains("<title>中国天气网</title")) {
                        str="<title>卢龙县</title>";
                    }
                    response.getWriter().write(str);
                }
                bufr.close();
            } else {
                System.err.println("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
