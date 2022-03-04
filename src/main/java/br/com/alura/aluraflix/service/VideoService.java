package br.com.alura.aluraflix.service;

import br.com.alura.aluraflix.domain.Video;
import br.com.alura.aluraflix.enums.ActiveFlagEnum;
import br.com.alura.aluraflix.exceptions.ResourceNotFoundException;
import br.com.alura.aluraflix.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VideoService {


    @Autowired
    private VideoRepository repository;

    public Video create(Video request) {
        request.setActiveFlag(ActiveFlagEnum.YES);
        return this.repository.save(request);
    }

    public Video findById(Long id) {
        Optional<Video> video = this.repository.findById(id);

        if(video.isPresent() && ActiveFlagEnum.NO.equals(video.get().getActiveFlag())) {
            throw new ResourceNotFoundException("Vídeo não encontrado!");
        }

        return video.orElseThrow(() -> new ResourceNotFoundException("Vídeo não encontrado!"));
    }

    public List<Video> findAll() {
        return this.repository.findAll().stream().filter(video -> ActiveFlagEnum.YES.equals(video.getActiveFlag()))
                .collect(Collectors.toList());
    }

    public Video update(Video request, Long id) {
        return this.repository.save(setVideoToUpdate(request, id));
    }

    public void delete(Long id) {
        Video video = findById(id);
        video.setActiveFlag(ActiveFlagEnum.NO);
        this.repository.save(video);
    }

    private Video setVideoToUpdate(Video request, Long id) {
        Video videoToUpdate = findById(id);

        videoToUpdate.setDescription(request.getDescription());
        videoToUpdate.setTitle(request.getTitle());
        videoToUpdate.setUrl(request.getUrl());

        return videoToUpdate;
    }

}
