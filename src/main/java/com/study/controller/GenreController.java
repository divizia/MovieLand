package com.study.controller;

import com.study.entity.Genre;
import com.study.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("genres")
public class GenreController {

    @Autowired
    private GenreService genreService;


    @GetMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("genres", genreService.findAll());
        return "tables/genres";
    }

    @GetMapping("/JSON")
    @ResponseBody
    public Iterable findAll() {
        return genreService.findAll();
    }

    @GetMapping("/add")
    public String addPage() {
        return "createPages/createGenre";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("genre") Genre genre) {
        genreService.save(genre);
        return "redirect:/genres/findAll";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        genreService.deleteById(id);
        return "redirect:/genres/findAll";
    }

    @GetMapping("/deleteAll")
    public String deleteAll() {
        genreService.deleteAll();
        return "redirect:/genres/findAll";
    }

    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable("id") int id, Model model) {
        model.addAttribute("genre", genreService.findById(id));
        return "updatePages/updateGenre";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("genre") Genre genre) {
        genreService.save(genre);
        return "redirect:/genres/findAll";
    }

    @PostMapping("/findAll")
    public String addFromFile(@ModelAttribute("file") MultipartFile file) {
        genreService.addFromFile(file);
        return "redirect:/genres/findAll";
    }

   /* @PostMapping("/genresJSON")
    @RequestBody
    public String addFromJSON(@ModelAttribute("file") MultipartFile file) {
        genreService.addFromFile(file);
        return "redirect:/genres/findAll";
    }*/

}
