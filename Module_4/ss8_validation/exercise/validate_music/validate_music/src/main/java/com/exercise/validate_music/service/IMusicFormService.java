package com.exercise.validate_music.service;

import com.exercise.validate_music.model.MusicForm;

public interface IMusicFormService {

    public String addFile(MusicForm musicForm, String fileUpload);

    public String updateFile(MusicForm musicForm, String fileUpload);

    public MusicForm showSongForm();

    public void deleteSongForm(String fileUpload, String song);
}
