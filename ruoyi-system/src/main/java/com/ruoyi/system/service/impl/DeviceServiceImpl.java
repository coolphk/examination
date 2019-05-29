package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.Device;
import com.ruoyi.system.domain.DeviceCpu;
import com.ruoyi.system.domain.DeviceVisit;
import com.ruoyi.system.mapper.DeviceMapper;
import com.ruoyi.system.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.support.Convert;

/**
 * 设备 服务层实现
 *
 * @author ruoyi
 * @date 2019-05-18
 */
@Service
public class DeviceServiceImpl implements IDeviceService {
    @Autowired
    private DeviceMapper deviceMapper;

    /**
     * 查询设备信息
     *
     * @param id 设备ID
     * @return 设备信息
     */
    @Override
    public Device selectDeviceById(Integer id) {
        return deviceMapper.selectDeviceById(id);
    }

    /**
     * 查询设备列表
     *
     * @param device 设备信息
     * @return 设备集合
     */
    @Override
    public List<Device> selectDeviceList(Device device) {
        return deviceMapper.selectDeviceList(device);
    }

    /***
     * 如果当前设备已存在数据库中，正常获取设备。如果当前设备状态不是正常状态，则将设备状态更新为正常状态
     * 如果没有存在则自动添加该设备
     * @param sn
     * @return
     */
    public Device selectDeviceBySN(String sn) {
        Device device = new Device();
        Device result = new Device();
        device.setSn(sn);
        List<Device> deviceList = deviceMapper.selectDeviceList(device);
        if (deviceList.size() > 0) {
            result = deviceList.get(0);
            if (result.getCurrentStatus() != 1) {
                device.setCurrentStatus(1);
                deviceMapper.updateDeviceStatusBySN(device);
            }
        } else {
            device.setCurrentStatus(1);
            deviceMapper.insertDevice(device);
            result = device;
        }
        return result;
    }

    /**
     * 新增设备
     *
     * @param device 设备信息
     * @return 结果
     */
    @Override
    public int insertDevice(Device device) {
        return deviceMapper.insertDevice(device);
    }

    /**
     * 修改设备
     *
     * @param device 设备信息
     * @return 结果
     */
    @Override
    public int updateDevice(Device device) {
        return deviceMapper.updateDevice(device);
    }

    /**
     * 删除设备对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDeviceByIds(String ids) {
        return deviceMapper.deleteDeviceByIds(Convert.toStrArray(ids));
    }

    @Override
    public List<Device> selectDeviceVisit() {
        return deviceMapper.selectDeviceVisit();
    }

    @Override
    public int insertDeviceVisit(DeviceVisit deviceVisit) {
        return deviceMapper.insertDeviceVisit(deviceVisit);
    }

    @Override
    public int insertDeviceCpu(DeviceCpu deviceCpu) {
        return deviceMapper.insertDeviceCpu(deviceCpu);
    }
}
