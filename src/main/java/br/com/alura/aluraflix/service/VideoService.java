package br.com.alura.aluraflix.service;

import br.com.alura.aluraflix.domain.Video;
import br.com.alura.aluraflix.exceptions.ResourceNotFoundException;
import br.com.alura.aluraflix.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {


    @Autowired
    private VideoRepository repository;

    public Video create(Video request) {
        return this.repository.save(request);
    }

    public Video findById(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vídeo não encontrado!"));
    }

    public List<Video> findAll() {
        return this.repository.findAll();
    }

}
