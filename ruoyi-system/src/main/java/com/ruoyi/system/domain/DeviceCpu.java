package com.ruoyi.system.domain;

import java.util.Date;

public class DeviceCpu {
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;
    /** 设备ID */
    private String deviceSn;
    /** 访问时间 */
    private Date visitTime;

    /** CPU占用率 */
    private Integer cpu;

    private Integer current;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public Integer getCpu() {
        return cpu;
    }

    public void setCpu(Integer cpu) {
        this.cpu = cpu;
    }
}
