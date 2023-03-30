package com.exercise.validate_music.controller;

import com.exercise.validate_music.model.Music;
import com.exercise.validate_music.model.MusicForm;
import com.exercise.validate_music.service.IMusicFormService;
import com.exercise.validate_music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@PropertySource("classpath:file_upload.properties")
public class MusicController {
    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private IMusicService musicService;

    @Autowired
    private IMusicFormService musicFormService;

    @GetMapping("")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("songs", musicService.showAll());
        modelAndView.addObject("filePath", fileUpload);
        return modelAndView;
    }

    @GetMapping("/showAddForm")
    public ModelAndView showAddForm() {
        ModelAndView modelAndView = new ModelAndView("addForm", "songs", new Music());
        return modelAndView;
    }

    @PostMapping("/upload")
    public String update(@ModelAttribute("songs") MusicForm musicForm, RedirectAttributes redirectAttributes) {
        String mess = "";
        String fileName = musicFormService.addFile(musicForm, fileUpload);
        if ("Wrong input".equals(fileName)) {
            mess = "Wrong input file type";
        } else if ("".equals(fileName)) {
            mess = "Can not add new song because of missing file upload";
        } else {
            Music music = new Music(musicForm.getName(), musicForm.getSinger(), musicForm.getType(), fileName);
            musicService.addSong(music);
            mess = "Upload successfully";
        }
        redirectAttributes.addFlashAttribute("msg", mess);
        return "redirect:/";
    }

    @GetMapping("/showEditForm/{name}")
    public ModelAndView showEditForm(@PathVariable("name") String name) {
        ModelAndView modelAndView = new ModelAndView("editForm", "song", musicService.showSong(name));
        return modelAndView;
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("songs") Music music, RedirectAttributes redirectAttributes) {
        musicService.updateSong(music);
        redirectAttributes.addFlashAttribute("msg", "Edit successfully");
        return "redirect:/";
    }

    @GetMapping("/delete/{name}/{song}")
    public String delete(@PathVariable("name") String name, @PathVariable("song") String song) {
        musicService.deleteSong(name);
        musicFormService.deleteSongForm(fileUpload, song);
        return "redirect:/";
    }

    @GetMapping(value = "/listen", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public Resource listen() {
        return new FileSystemResource("D:\\Code gym\\Program\\Module_4\\ss5_ORM\\exercise\\music_app\\exercise\\src\\main\\webapp\\upload");
    }
}
