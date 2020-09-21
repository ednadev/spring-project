package com.project.spring.web.dto;

import com.project.spring.domain.gallery.Gallery;
import lombok.Getter;

@Getter
public class GalleryResponseDto {

    private Long id;
    private String imageName;
    private String imageSize;
    private String userName;

    public GalleryResponseDto(Gallery entity) {
        this.id = entity.getId();
        this.imageName = entity.getImageName();
        this.imageSize = entity.getImageSize();
        this.userName = entity.getUserName();
    }
}
