package com.project.spring.web.dto;

import org.springframework.web.multipart.MultipartFile;

public class UploadData {
    private MultipartFile uploadFile;

    public MultipartFile getUploadFile() {
        return uploadFile;
    }
    public void setUploadFile(MultipartFile uploadFile) {
        this.uploadFile = uploadFile;
    }
}
