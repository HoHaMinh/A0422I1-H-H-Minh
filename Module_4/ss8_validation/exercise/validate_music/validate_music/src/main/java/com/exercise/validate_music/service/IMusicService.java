package com.exercise.validate_music.service;

import com.exercise.validate_music.model.Music;
import java.util.List;

public interface IMusicService {
    public List<Music> showAll();

    public void addSong(Music music);

    public void updateSong(Music music);

    public Music showSong(String name);

    public void deleteSong(String name);
}
