package com.exercise.validate_music.repository;

import com.exercise.validate_music.model.MusicForm;
import org.springframework.stereotype.Repository;

public interface IMusicFormRepository {

    public void addFile(MusicForm musicForm, String fileUpload, String fileMame);

    public String updateFile(MusicForm musicForm, String fileUpload, String fileMame);

    public MusicForm showSongForm();

    public void deleteSongForm(String fileUpload, String song);
}
