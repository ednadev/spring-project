package com.project.spring.web.dto;

import com.project.spring.domain.gallery.Gallery;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GallerySaveRequestDto {
    private String imageName;
    private String imageSize;
    private String userName;

    @Builder
    public GallerySaveRequestDto(String imageName, String imageSize, String userName) {
        this.imageName = imageName;
        this.imageSize = imageSize;
        this.userName = userName;
    }

    public Gallery toEntity() {
        return Gallery.builder()
                .imageName(imageName)
                .imageSize(imageSize)
                .userName(userName)
                .build();
    }
}
