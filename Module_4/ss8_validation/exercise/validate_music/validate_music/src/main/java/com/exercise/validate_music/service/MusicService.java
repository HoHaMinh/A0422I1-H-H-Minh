package com.exercise.validate_music.service;

import com.exercise.validate_music.model.Music;
import com.exercise.validate_music.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public List<Music> showAll() {
        return (List<Music>) musicRepository.findAll();
    }

    @Override
    public void addSong(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void updateSong(Music music) {
        musicRepository.save(music);
    }

    @Override
    public Music showSong(String name) {
        return musicRepository.findByName(name);
    }

    @Override
    public void deleteSong(String name) {
        musicRepository.deleteByName(name);
    }
}
