package br.com.alura.aluraflix.controller;

import br.com.alura.aluraflix.domain.Video;
import br.com.alura.aluraflix.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoService service;

    @PostMapping
    public ResponseEntity<Video> create(@RequestBody @Valid final Video request) {
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }

}
