package com.exercise.validate_music.validate;

import com.exercise.validate_music.model.MusicForm;
import com.exercise.validate_music.service.IMusicFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidatorMusic implements Validator {
    public static boolean checkFileType(String fileName) {
        String regexFileName = "^[\\w-]+\\.(mp3|wav|ogg|mp4)$";
        return fileName.matches(regexFileName);
    }

    @Autowired
    private IMusicFormService musicFormService;

    @Override
    public boolean supports(Class<?> clazz) {
        return MusicForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(!(target instanceof MusicForm)) {
            return;
        }
        MusicForm musicForm = (MusicForm) target;
        if ("".equals(musicForm.getName())) {
            errors.rejectValue("name", "name", "Can not empty the name of music");
        }

        if ("".equals(musicForm.getSinger())) {
            errors.rejectValue("singer", "singer", "Can not empty the name of singer");
        }

        if ("".equals(musicForm.getType())) {
            errors.rejectValue("type", "type", "Can not empty the type of music");
        }

        if (musicForm.getName().length()>800) {
            errors.rejectValue("name", "name", "Name of music can not over 800 char");
        }

        if (musicForm.getSinger().length()>300) {
            errors.rejectValue("singer", "singer", "Name of singer can not over 300 char");
        }

        if (musicForm.getType().length()>1000) {
            errors.rejectValue("type", "type", "Type of music can not over 1000 char");
        }

        String regex = "^[a-zA-Z0-9\\s]*$";
        String regex1 = "^[a-zA-Z0-9\\s,]*$";


        if (!musicForm.getName().matches(regex)){
            errors.rejectValue("name","name","Name of music can not contain special symbols");
        }

        if (!musicForm.getSinger().matches(regex)){
            errors.rejectValue("singer","singer","Name of singer can not contain special symbols");
        }

        if (!musicForm.getType().matches(regex1)){
            errors.rejectValue("type","type","Type of music can not contain special symbols");
        }
    }
}
