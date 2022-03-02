package br.com.alura.aluraflix.service;

import br.com.alura.aluraflix.domain.Video;
import br.com.alura.aluraflix.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {


    @Autowired
    private VideoRepository repository;

    public Video create(Video request) {
        return this.repository.save(request);
    }

}