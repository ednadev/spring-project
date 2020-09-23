package com.project.spring.web;

import com.project.spring.domain.gallery.Gallery;
import com.project.spring.domain.gallery.GalleryRepository;
import com.project.spring.web.dto.GallerySaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GalleryApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private GalleryRepository galleryRepository;

    @After
    public void tearDown() throws Exception {
        galleryRepository.deleteAll();
    }

    @Test
    public void gallerySave() throws Exception {
        String imageName = "imageName";
        String imageSize = "imageSize";
        GallerySaveRequestDto requestDto = GallerySaveRequestDto.builder()
                .imageName(imageName)
                .imageSize(imageSize)
                .userName("userName")
                .build();

        String url = "http://localhost:" + port + "/gallery";

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Gallery> all = galleryRepository.findAll();
        assertThat(all.get(0).getImageName()).isEqualTo(imageName);
        assertThat(all.get(0).getImageSize()).isEqualTo(imageSize);
    }
}
