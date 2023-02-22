package com.techavaliation.cooperativism.dtos;

import java.util.Date;

public class SessionDTO {
    
    private Date timer;

    private Long scheduleId;

    public Date getTimer() {
        return timer;
    }

    public void setTimer(Date timer) {
        this.timer = timer;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

}
