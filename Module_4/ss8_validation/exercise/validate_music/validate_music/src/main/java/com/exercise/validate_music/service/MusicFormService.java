package com.exercise.validate_music.service;

import com.exercise.validate_music.model.MusicForm;
import com.exercise.validate_music.repository.IMusicFormRepository;
import com.exercise.validate_music.validate.ValidatorMusic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;

@Service
@Transactional
public class MusicFormService implements IMusicFormService{
    @Autowired
    private IMusicFormRepository musicFormRepository;

    @Override
    public String addFile(MusicForm musicForm, String fileUpload) {
        MultipartFile multipartFile = musicForm.getSong();
        String fileName = multipartFile.getOriginalFilename();
        if ("".equals(fileName)) {
            return fileName;
        } else {
            if (ValidatorMusic.checkFileType(fileName)) {
                musicFormRepository.addFile(musicForm, fileUpload, fileName);
                return fileName;
            } else {
                fileName = "Wrong input";
                return fileName;
            }
        }
    }

    @Override
    public String updateFile(MusicForm musicForm, String fileUpload) {
        MultipartFile multipartFile = musicForm.getSong();
        String fileName = multipartFile.getOriginalFilename();
        if ("".equals(fileName)) {
            return fileName;
        } else {
            if (ValidatorMusic.checkFileType(fileName)) {
                musicFormRepository.addFile(musicForm, fileUpload, fileName);
                return fileName;
            } else {
                fileName = "Wrong input";
                return fileName;
            }
        }
    }

    @Override
    public MusicForm showSongForm() {
        return null;
    }

    @Override
    public void deleteSongForm(String fileUpload, String song) {
        musicFormRepository.deleteSongForm(fileUpload, song);
    }
}
