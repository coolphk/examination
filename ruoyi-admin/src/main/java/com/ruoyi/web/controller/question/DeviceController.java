package com.ruoyi.web.controller.question;

import java.util.List;

import com.ruoyi.system.domain.Device;
import com.ruoyi.system.service.IDeviceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 设备 信息操作处理
 *
 * @author ruoyi
 * @date 2019-05-18
 */
@Controller
@RequestMapping("/device")
public class DeviceController extends BaseController {
    private String prefix = "/device";

    @Autowired
    private IDeviceService deviceService;

    @RequiresPermissions("web:device:view")
    @GetMapping()
    public String device() {
        return prefix + "/device";
    }

    /**
     * 查询设备列表
     */
    @RequiresPermissions("web:device:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Device device) {
        startPage();
        List<Device> list = deviceService.selectDeviceList(device);
        return getDataTable(list);
    }


    /**
     * 导出设备列表
     */
    @RequiresPermissions("web:device:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Device device) {
        List<Device> list = deviceService.selectDeviceList(device);
        ExcelUtil<Device> util = new ExcelUtil<Device>(Device.class);
        return util.exportExcel(list, "device");
    }

    /**
     * 新增设备
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存设备
     */
    @RequiresPermissions("web:device:add")
    @Log(title = "设备", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Device device) {
        return toAjax(deviceService.insertDevice(device));
    }

    /**
     * 修改设备
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        Device device = deviceService.selectDeviceById(id);
        mmap.put("device", device);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备
     */
    @RequiresPermissions("web:device:edit")
    @Log(title = "设备", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Device device) {
        return toAjax(deviceService.updateDevice(device));
    }

    /**
     * 删除设备
     */
    @RequiresPermissions("web:device:remove")
    @Log(title = "设备", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(deviceService.deleteDeviceByIds(ids));
    }


    @GetMapping("/visitdata")
    @ResponseBody
    public List<Device> selectDeviceVisit() {
        return deviceService.selectDeviceVisit();
    }

    @GetMapping("/visit")
    public String visitCharts() {
        return prefix+"/visit";
    }

}
