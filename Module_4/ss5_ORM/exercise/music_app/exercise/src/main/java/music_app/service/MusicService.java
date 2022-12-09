package music_app.service;

import music_app.bean.Music;
import music_app.bean.MusicForm;
import music_app.repository.IMusicRepository;
import music_app.validate.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
public class MusicService implements IMusicService{
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public List<Music> showAll() {
        return musicRepository.showAll();
    }

    @Override
    public void addSong(Music music) {
        musicRepository.addSong(music);
    }

    @Override
    public String addFile(MusicForm musicForm, String fileUpload) {
        MultipartFile multipartFile = musicForm.getSong();
        String fileName = multipartFile.getOriginalFilename();
        if ("".equals(fileName)) {
            return fileName;
        } else if (Validator.checkFileType(fileName)) {
            musicRepository.addFile(musicForm, fileUpload, fileName);
            return fileName;
        } else {
            fileName = "Wrong input";
            return fileName;
        }
    }

    @Override
    public void updateSong(Music music) {
        musicRepository.updateSong(music);
    }

    @Override
    public String updateFile(MusicForm musicForm, String fileUpload) {
        MultipartFile multipartFile = musicForm.getSong();
        String fileName = multipartFile.getOriginalFilename();
        if ("".equals(fileName)) {
            return fileName;
        } else if (Validator.checkFileType(fileName)) {
            musicRepository.addFile(musicForm, fileUpload, fileName);
            return fileName;
        } else {
            fileName = "Wrong input";
            return fileName;
        }
    }

    @Override
    public Music showSong(String name) {
        return musicRepository.showSong(name);
    }

    @Override
    public MusicForm showSongForm() {
        return musicRepository.showSongForm();
    }

    @Override
    public void deleteSong(String name) {
        musicRepository.deleteSong(name);
    }

    @Override
    public void deleteSongForm(String fileUpload, String song) {
        musicRepository.deleteSongForm(fileUpload,song);
    }
}
