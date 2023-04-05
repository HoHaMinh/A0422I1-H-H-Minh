package com.exercise.validate_music.repository;

import com.exercise.validate_music.model.MusicForm;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Repository
@Transactional
public class MusicFormRepository implements IMusicFormRepository{
    @Override
    public void addFile(MusicForm musicForm, String fileUpload, String fileName) {
        try {
            FileCopyUtils.copy(musicForm.getSong().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String updateFile(MusicForm musicForm, String fileUpload, String fileMame) {
        return null;
    }

    @Override
    public MusicForm showSongForm() {
        return null;
    }

    @Override
    public void deleteSongForm(String fileUpload, String song) {
        try {
            Files.delete(Paths.get(fileUpload + song));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
