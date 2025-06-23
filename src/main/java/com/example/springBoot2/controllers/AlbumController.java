package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Album;

import com.example.springBoot2.repositories.AlbumRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlbumController {
    private final AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @GetMapping("/albums")
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @GetMapping("/albums/{id}")
    public Album getAlbum(@PathVariable int id) {
        return albumRepository.findById(id).orElse(null);
    }

    @PostMapping("/albums")
    public Album addAlbum(@RequestBody Album album) {
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
