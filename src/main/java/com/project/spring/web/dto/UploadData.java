package com.project.spring.web.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class UploadData {
    private MultipartFile uploadFile;
    private String userName;
}
