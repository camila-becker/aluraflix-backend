package br.com.alura.aluraflix.controller;

import br.com.alura.aluraflix.domain.Video;
import br.com.alura.aluraflix.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoService service;

    @PostMapping
    public ResponseEntity<Video> create(@RequestBody @Valid final Video request) {
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Video> findById(@PathVariable final Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Video>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

}
