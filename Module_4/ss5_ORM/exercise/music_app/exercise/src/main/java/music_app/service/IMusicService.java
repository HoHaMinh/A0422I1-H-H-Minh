package music_app.service;

import music_app.bean.Music;
import music_app.bean.MusicForm;

import java.util.List;

public interface IMusicService {
    public List<Music> showAll ();
    public void addSong(Music music);
    public String addFile(MusicForm musicForm, String fileUpload);
    public void updateSong (Music music);
    public String updateFile (MusicForm musicForm, String fileUpload);
    public Music showSong (String name);
    public MusicForm showSongForm ();
    public void deleteSong (String name);
    public void deleteSongForm (String fileUpload, String song);
}
