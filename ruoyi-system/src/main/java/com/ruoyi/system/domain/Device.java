package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

import java.util.List;

/**
 * 设备表 sys_device
 * 
 * @author ruoyi
 * @date 2019-05-18
 */
public class Device extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 设备名称 */
	private String name;
	/** 设备序列号 */
	private String sn;
	/** 设备描述 */
	private String description;
	/** 当前状态 */
	private Integer currentStatus;

	private List<DeviceVisit> deviceVisitList;

	private List<DeviceCpu> deviceCpuList;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setSn(String sn) 
	{
		this.sn = sn;
	}

	public String getSn() 
	{
		return sn;
	}

	public void setCurrentStatus(Integer currentStatus) 
	{
		this.currentStatus = currentStatus;
	}

	public Integer getCurrentStatus() 
	{
		return currentStatus;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<DeviceVisit> getDeviceVisitList() {
		return deviceVisitList;
	}

	public void setDeviceVisitList(List<DeviceVisit> deviceVisitList) {
		this.deviceVisitList = deviceVisitList;
	}

	public List<DeviceCpu> getDeviceCpuList() {
		return deviceCpuList;
	}

	public void setDeviceCpuList(List<DeviceCpu> deviceCpuList) {
		this.deviceCpuList = deviceCpuList;
	}
}
