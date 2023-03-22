package music_app.repository;

import music_app.bean.Music;
import music_app.bean.MusicForm;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Repository
@Transactional
public class MusicRepository implements IMusicRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Music> showAll() {
        return entityManager.createQuery("select m from Music m").getResultList();
    }

    @Override
    public void addSong(Music music) {
        entityManager.persist(music);
    }

    @Override
    public void addFile(MusicForm musicForm, String fileUpload, String fileName) {
        try {
            FileCopyUtils.copy(musicForm.getSong().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateSong(Music music) {
        entityManager.merge(music);
    }

    @Override
    public String updateFile(MusicForm musicForm, String fileUpload, String fileMame) {
        return null;
    }

    @Override
    public Music showSong(String name) {
        return entityManager.find(Music.class, name);
    }

    @Override
    public MusicForm showSongForm() {
        return null;
    }

    @Override
    public void deleteSong(String name) {
        entityManager.remove(showSong(name));
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
