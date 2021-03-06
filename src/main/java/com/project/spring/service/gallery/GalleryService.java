package com.project.spring.service.gallery;

import com.project.spring.domain.gallery.Gallery;
import com.project.spring.domain.gallery.GalleryRepository;
import com.project.spring.web.dto.GalleryListResponseDto;
import com.project.spring.web.dto.GalleryResponseDto;
import com.project.spring.web.dto.GallerySaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GalleryService {
    private final GalleryRepository galleryRepository;

    @Transactional
    public Long save(GallerySaveRequestDto requestDto) {
        return galleryRepository.save(requestDto.toEntity()).getId();
    }

    public GalleryResponseDto findById(Long id) {
        Gallery entity = galleryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 이미지가 없습니다. id=" + id));
        return new GalleryResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<GalleryListResponseDto> findAllDesc() {
        return galleryRepository.findAllDesc().stream()
                .map(GalleryListResponseDto::new)
                .collect(Collectors.toList());
    }
}
