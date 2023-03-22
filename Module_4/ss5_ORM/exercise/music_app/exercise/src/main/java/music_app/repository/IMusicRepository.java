package music_app.repository;

import music_app.bean.Music;
import music_app.bean.MusicForm;
import java.util.List;

public interface IMusicRepository {
    public List<Music> showAll();

    public void addSong(Music music);

    public void addFile(MusicForm musicForm, String fileUpload, String fileMame);

    public void updateSong(Music music);

    public String updateFile(MusicForm musicForm, String fileUpload, String fileMame);

    public Music showSong(String name);

    public MusicForm showSongForm();

    public void deleteSong(String name);

    public void deleteSongForm(String fileUpload, String song);
}
