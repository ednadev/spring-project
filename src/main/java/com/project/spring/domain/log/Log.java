package com.project.spring.domain.log;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String logDate;
    private String logCheck;

    @Builder
    public Log(String userName, String logDate, String logCheck) {
        this.userName = userName;
        this.logDate = logDate;
        this.logCheck = logCheck;
    }
}
