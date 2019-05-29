package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 设备参观表 sys_device_visit
 * 
 * @author ruoyi
 * @date 2019-05-19
 */
public class DeviceVisit
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 设备ID */
	private String deviceSn;
	/** 访问时间 */
	private Date visitTime;
	/**  */
	private String visitType;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setDeviceSn(String deviceSn) 
	{
		this.deviceSn = deviceSn;
	}

	public String getDeviceSn() 
	{
		return deviceSn;
	}
	public void setVisitTime(Date visitTime) 
	{
		this.visitTime = visitTime;
	}

	public Date getVisitTime() 
	{
		return visitTime;
	}
	public void setVisitType(String visitType) 
	{
		this.visitType = visitType;
	}

	public String getVisitType() 
	{
		return visitType;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceSn", getDeviceSn())
            .append("visitTime", getVisitTime())
            .append("visitType", getVisitType())
            .toString();
    }
}
