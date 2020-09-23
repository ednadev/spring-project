package com.project.spring.domain.log;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogRepositoryTest {
    @Autowired
    LogRepository logRepository;

    @After
    public void cleanup() {
        logRepository.deleteAll();
    }

    @Test
    public void logSave() {
        String userName = "ednadev@naver.com";
        String logDate = "2020/09/22...";
        String logCheck = "로그인";

        logRepository.save(Log.builder()
            .userName(userName)
            .logDate(logDate)
            .logCheck(logCheck)
            .build());

        List<Log> logList = logRepository.findAll();

        Log log = logList.get(0);
        assertThat(log.getUserName()).isEqualTo(userName);
        assertThat(log.getLogDate()).isEqualTo(logDate);
        assertThat(log.getLogCheck()).isEqualTo(logCheck);
    }
}
