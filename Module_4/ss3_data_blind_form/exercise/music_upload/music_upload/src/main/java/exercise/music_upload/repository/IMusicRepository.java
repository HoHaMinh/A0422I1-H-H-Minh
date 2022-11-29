package exercise.music_upload.repository;

import exercise.music_upload.bean.Music;
import exercise.music_upload.bean.MusicForm;

import java.util.List;

public interface IMusicRepository {
    public List<Music> showAll ();
    public void saveSong(Music music);
    public void saveFile(MusicForm musicForm, String fileUpload, String fileName);
}
