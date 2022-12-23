package exercise.music_upload.service;

import exercise.music_upload.bean.Music;
import exercise.music_upload.bean.MusicForm;
import exercise.music_upload.repository.IMusicRepository;
import exercise.music_upload.validate.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public List<Music> showAll() {
        return musicRepository.showAll();
    }

    @Override
    public void saveSong(Music music) {
        musicRepository.saveSong(music);
    }

    @Override
    public String saveFile(MusicForm musicForm, String fileUpload) {
        MultipartFile multipartFile = musicForm.getSong();
        String fileName = multipartFile.getOriginalFilename();
        if ("".equals(fileName)) {
            return fileName;
        } else if (Validator.checkFileType(fileName)) {
            musicRepository.saveFile(musicForm, fileUpload, fileName);
            return fileName;
        } else {
            fileName = "Wrong input";
            return fileName;
        }
    }
}
