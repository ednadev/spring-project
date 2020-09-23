package com.project.spring.service.log;

import com.project.spring.domain.log.LogRepository;
import com.project.spring.web.dto.LogListResponseDto;
import com.project.spring.web.dto.LogSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LogService {
    private final LogRepository logRepository;

    @Transactional
    public Long save(LogSaveRequestDto requestDto) {
        return logRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<LogListResponseDto> findAllDesc() {
        return logRepository.findAllDesc().stream()
                .map(LogListResponseDto::new)
                .collect(Collectors.toList());
    }
}
