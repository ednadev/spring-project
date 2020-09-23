package com.project.spring.web;

import com.project.spring.config.auth.dto.SessionUser;
import com.project.spring.service.gallery.GalleryService;
import com.project.spring.service.log.LogService;
import com.project.spring.web.dto.GalleryResponseDto;
import com.project.spring.web.dto.GallerySaveRequestDto;
import com.project.spring.web.dto.UploadData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final GalleryService galleryService;
    private final LogService logService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("gallery", galleryService.findAllDesc());

        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user!=null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/log")
    public String log(Model model) {
        model.addAttribute("log", logService.findAllDesc());
        return "log";
    }

    @GetMapping("/gallery/{id}")
    public String galleryDetail(@PathVariable Long id, Model model) {
        GalleryResponseDto dto = galleryService.findById(id);
        model.addAttribute("gallery", dto);
        return "popup";
    }

}
