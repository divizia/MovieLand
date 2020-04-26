package com.study.controller;

import com.study.entity.Genre;
import com.study.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GenreController {

    @Autowired
    private GenreService genreService;


    @GetMapping("/genres")
    public String findAll(Model model) {
        model.addAttribute("genres", genreService.findAll());
        return "tables/genres";
    }

    @GetMapping("/addGenre")
    public String addPage() {
        return "createPages/createGenre";
    }

    @PostMapping("/addGenre")
    public String add(@ModelAttribute("genre") Genre genre) {
        genreService.save(genre);
        return "redirect:/genres";
    }

    @GetMapping("/deleteGenre/{id}")
    public String delete(@PathVariable("id") int id) {
        genreService.deleteById(id);
        return "redirect:/genres";
    }

    @GetMapping("/deleteAllGenres")
    public String deleteAll() {
        genreService.deleteAll();
        return "redirect:/genres";
    }

    @GetMapping("/updateGenre/{id}")
    public String updatePage(@PathVariable("id") int id, Model model) {
        model.addAttribute("genre", genreService.findById(id));
        return "updatePages/updateGenre";
    }

    @PostMapping("/updateGenre")
    public String update(@ModelAttribute("genre") Genre genre) {
        genreService.save(genre);
        return "redirect:/genres";
    }

}
