package com.example.foto.controllers;

import com.example.foto.services.PhotoService;
import com.example.foto.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/usuarios")
public class UserContoller {

    private final UserService userService;
    private final PhotoService photoService;

    public UserContoller(UserService userService, PhotoService photoService) {
        this.userService = userService;
        this.photoService = photoService;
    }

    @PostMapping
    public ResponseEntity<?> saveUSer(@RequestParam String name,
                                      @RequestParam String email,
                                      @RequestParam MultipartFile photo) throws IOException {
        String pathPhoto = photoService.savePhoto(photo);
        return ResponseEntity.ok(userService.saveUser(name, email, pathPhoto));
    }


}
