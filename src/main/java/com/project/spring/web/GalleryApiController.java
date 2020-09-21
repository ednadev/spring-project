package com.project.spring.web;

import com.project.spring.service.gallery.GalleryService;
import com.project.spring.web.dto.GalleryResponseDto;
import com.project.spring.web.dto.GallerySaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class GalleryApiController {

    private final GalleryService galleryService;

    @PostMapping("/api/gallery")
    public Long save(@RequestBody GallerySaveRequestDto requestDto) {
        return galleryService.save(requestDto);
    }

    @GetMapping("/api/gallery/{id}")
    public GalleryResponseDto findById(@PathVariable Long id) {
        return galleryService.findById(id);
    }
}
