package com.project.spring.domain.gallery;

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
public class GalleryRepositoryTest {

    @Autowired
    GalleryRepository galleryRepository;

    @After
    public void cleanup() {
        galleryRepository.deleteAll();
    }

    @Test
    public void gallerySave() {
        String imageName = "이미지 이름";
        String imageSize = "이미지 사이즈";

        galleryRepository.save(Gallery.builder()
            .imageName(imageName)
            .imageSize(imageSize)
            .userName("ednadev@naver.com")
            .build());

        List<Gallery> galleryList = galleryRepository.findAll();

        Gallery gallery = galleryList.get(0);
        assertThat(gallery.getImageName()).isEqualTo(imageName);
        assertThat(gallery.getImageSize()).isEqualTo(imageSize);
    }
}
