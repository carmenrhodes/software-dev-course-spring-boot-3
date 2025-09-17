package com.example.springBoot2.controllers;

import com.example.springBoot2.repositories.AlbumRepository;
import com.example.springBoot2.models.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlbumController {
    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping("/albums")
    public List<Album> getAlbums() {
        return albumRepository.findAll();
    }

    @GetMapping("/albums/{id}")
    public Album getAlbum(@PathVariable int id) {
        return albumRepository.findById(id).orElse(null);
    }

    @PostMapping("/albums")
    public Album createAlbum(@RequestBody Album album) {
        return albumRepository.save(album);
    }

    @PutMapping("/albums/{id}")
    public Album updateAlbum(@PathVariable int id, @RequestBody Album album) {
        album.setId(id);
        return albumRepository.save(album);
    }

    @DeleteMapping("/albums/{id}")
    public void deleteAlbum(@PathVariable int id) {
        albumRepository.deleteById(id);
    }
}