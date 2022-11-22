package exercise.dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@Controller
public class DictionaryServlet {
@GetMapping({"/","/home"})
    public String goHome(){
    return "home";
}

@GetMapping("/translate")
    public String translate(@RequestParam("word") String word, Model model) {
    List<String> vietnamese = new ArrayList<>();
    vietnamese.add("xe");
    vietnamese.add("xin chào");
    vietnamese.add("sách");
    List<String> english = new ArrayList<>();
    english.add("car");
    english.add("hello");
    english.add("book");
    String result="";
    for (int i=0; i<english.size(); i++) {
        if(word.equals(english.get(i))) {
            result=vietnamese.get(i);
            break;
        } result="Do not find this word!";
    }

    model.addAttribute("result",result);
    return "home";
}
}