package com.ruoyi.web.controller.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.system.domain.Device;
import com.ruoyi.system.domain.DeviceCpu;
import com.ruoyi.system.domain.DeviceVisit;
import com.ruoyi.system.service.IDeviceService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.framework.config.ServerConfig;
import com.ruoyi.framework.util.FileUploadUtils;

/**
 * 通用请求处理
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/common")
public class CommonController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    /**
     * 文件上传路径
     */
    public static final String UPLOAD_PATH = "/profile/upload/";

    @Autowired
    private ServerConfig serverConfig;
    @Autowired
    private IDeviceService deviceService;

    /**
     * 通用下载请求
     *
     * @param fileName 文件名称
     * @param delete   是否删除
     */
    @GetMapping("/download")
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request) {
        String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
        try {
            String filePath = Global.getDownloadPath() + fileName;

            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + setFileDownloadHeader(request, realFileName));
            FileUtils.writeBytes(filePath, response.getOutputStream());
            if (delete) {
                FileUtils.deleteFile(filePath);
            }
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }

    /**
     * 通用上传请求
     */
    @ApiOperation("上传文件")
    @PostMapping("/upload")
    @ResponseBody
    public AjaxResult uploadFile(MultipartFile file) throws Exception {
        try {
            // 上传文件路径
            String filePath = Global.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + UPLOAD_PATH + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("url", url);
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    public String setFileDownloadHeader(HttpServletRequest request, String fileName) throws UnsupportedEncodingException {
        final String agent = request.getHeader("USER-AGENT");
        String filename = fileName;
        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            filename = new String(fileName.getBytes(), "ISO8859-1");
        } else if (agent.contains("Chrome")) {
            // google浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }

    @ApiOperation("根据序列号获取设备状态")
    @GetMapping("/selectDeviceStatusBySN")
    @ResponseBody
    public AjaxResult selectDeviceStatusBySN(String sn) {
        AjaxResult ajaxResult = new AjaxResult();
        Device device = deviceService.selectDeviceBySN(sn);
        if (device != null) {
            ajaxResult.put("name", device.getName());
            ajaxResult.put("sn", device.getSn());
            ajaxResult.put("current", device.getCurrentStatus());
        }
        return ajaxResult;
    }

    /**
     * 设备访问次数
     * @param deviceVisit
     * @return
     */
    @ApiOperation("访问接口")
    @GetMapping("/visit")
    @ResponseBody
    public AjaxResult visit(DeviceVisit deviceVisit) {
        deviceVisit.setVisitTime(new Date());
        return toAjax(deviceService.insertDeviceVisit(deviceVisit));
    }

    @ApiOperation("上报CPU使用率")
    @GetMapping("/uploadcpu")
    @ResponseBody
    public AjaxResult uploadcpu(DeviceCpu deviceCpu) {
        deviceCpu.setVisitTime(new Date());
        return toAjax(deviceService.insertDeviceCpu(deviceCpu));
    }
}
