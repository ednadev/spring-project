package com.project.spring.web.dto;

import com.project.spring.domain.log.Log;
import lombok.Getter;

@Getter
public class LogListResponseDto {
    private Long id;
    private String userName;
    private String logDate;
    private String logCheck;

    public LogListResponseDto(Log entity) {
        this.id = entity.getId();
        this.userName = entity.getUserName();
        this.logDate = entity.getLogDate();
        this.logCheck = entity.getLogCheck();
    }
}
