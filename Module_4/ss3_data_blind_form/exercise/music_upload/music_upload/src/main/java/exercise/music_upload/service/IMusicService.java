package exercise.music_upload.service;

import exercise.music_upload.bean.Music;
import exercise.music_upload.bean.MusicForm;

import java.util.List;

public interface IMusicService {
    public List<Music> showAll ();
    public void saveSong(Music music);
    public String saveFile(MusicForm musicForm, String fileUpload);
}
