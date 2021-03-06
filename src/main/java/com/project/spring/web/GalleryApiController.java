package com.project.spring.web;

import com.project.spring.service.gallery.GalleryService;
import com.project.spring.web.dto.GallerySaveRequestDto;
import com.project.spring.web.dto.UploadData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RequiredArgsConstructor
@RestController
@RequestMapping("api")
public class GalleryApiController {

    private final GalleryService galleryService;

    @PostMapping("gallery")
    public ResponseEntity uploadFile(@ModelAttribute UploadData upload) throws Exception {
        GallerySaveRequestDto requestDto = new GallerySaveRequestDto();
        MultipartFile mFile = upload.getUploadFile();
        if (mFile.isEmpty() != true) {
            requestDto.setImageName(mFile.getOriginalFilename());
            requestDto.setImageSize(Long.toString(mFile.getSize()));
        }

        String path = "C:\\spring-project\\src\\main\\resources\\static\\image\\";

        File copyFile = new File(path + mFile.getOriginalFilename());
        mFile.transferTo(copyFile);

        requestDto.setUserName(upload.getUserName());
        galleryService.save(requestDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
