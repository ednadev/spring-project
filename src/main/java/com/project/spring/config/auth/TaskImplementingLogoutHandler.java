package com.project.spring.config.auth;

import com.project.spring.config.auth.dto.SessionUser;
import com.project.spring.domain.log.Log;
import com.project.spring.domain.log.LogRepository;
import com.project.spring.domain.user.User;
import com.project.spring.web.dto.LogSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class TaskImplementingLogoutHandler implements LogoutHandler {

    private final LogRepository logRepository;
    private final HttpSession httpSession;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String date_now = sdf.format(now);

        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        //로그기록 남기기
        LogSaveRequestDto requestDto = new LogSaveRequestDto();
        requestDto.setUserName(user.getName());
        requestDto.setLogDate(date_now);
        requestDto.setLogCheck("로그아웃");

        logRepository.save(Log.builder()
                .userName(requestDto.getUserName())
                .logDate(requestDto.getLogDate())
                .logCheck(requestDto.getLogCheck())
                .build());
    }

}
