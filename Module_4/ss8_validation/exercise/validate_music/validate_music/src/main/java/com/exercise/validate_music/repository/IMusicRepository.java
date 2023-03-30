package com.exercise.validate_music.repository;

import com.exercise.validate_music.model.Music;
import org.springframework.data.repository.CrudRepository;

public interface IMusicRepository extends CrudRepository<Music,String> {
    Music findByName(String name);
    void deleteByName(String name);
}
