package com.project.spring.web.dto;

import com.project.spring.domain.gallery.Gallery;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GalleryListResponseDto {
    private Long id;
    private String imageName;
    private String imageSize;
    private String userName;
    private LocalDateTime modifiedDate;

    public GalleryListResponseDto(Gallery entity) {
        this.id = entity.getId();
        this.imageName = entity.getImageName();
        this.imageSize = entity.getImageSize();
        this.userName = entity.getUserName();
        this.modifiedDate = entity.getModifiedDate();
    }
}
