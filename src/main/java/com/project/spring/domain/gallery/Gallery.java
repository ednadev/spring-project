package com.project.spring.domain.gallery;

import com.project.spring.domain.BaseTimeEntity;
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
public class Gallery extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageName;
    private String imageSize;
    private String userName;

    @Builder
    public Gallery(String imageName, String imageSize, String userName) {
        this.imageName = imageName;
        this.imageSize = imageSize;
        this.userName = userName;
    }
}
