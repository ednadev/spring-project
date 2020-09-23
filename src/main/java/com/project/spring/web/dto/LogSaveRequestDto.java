package com.project.spring.web.dto;

import com.project.spring.domain.log.Log;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LogSaveRequestDto {
    private String userName;
    private String logDate;
    private String logCheck;

    @Builder
    public LogSaveRequestDto(String userName, String logDate, String logCheck) {
        this.userName = userName;
        this.logDate = logDate;
        this.logCheck = logCheck;
    }

    public Log toEntity() {
        return Log.builder()
                .userName(userName)
                .logDate(logDate)
                .logCheck(logCheck)
                .build();
    }
}
