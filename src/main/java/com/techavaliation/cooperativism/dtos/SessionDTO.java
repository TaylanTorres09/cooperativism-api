package com.techavaliation.cooperativism.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

public class SessionDTO {
    
    @Nullable
    private Integer minutes;

    @NotNull(message = "ID da pauta necessária")
    private Long scheduleId;

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

}
