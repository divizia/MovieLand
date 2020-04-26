package com.study.controller;

import com.study.entity.Movie;
import com.study.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("movies", movieService.findAll());
        return "tables/movies";
    }

    @GetMapping("/JSON")
    @ResponseBody
    public Iterable findAll() {
        return movieService.findAll();
    }

    @GetMapping("/add")
    public String addPage() {
        return "createPages/createMovie";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("movies") Movie movie) {
        movieService.save(movie);
        return "redirect:/movies/findAll";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        movieService.deleteById(id);
        return "redirect:/movies/findAll";
    }

    @GetMapping("/deleteAll")
    public String deleteAll() {
        movieService.deleteAll();
        return "redirect:/movies/findAll";
    }

    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable("id") int id, Model model) {
        model.addAttribute("movie", movieService.findById(id));
        return "updatePages/updateMovie";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("movie") Movie movie) {
        movieService.save(movie);
        return "redirect:/movies/findAll";
    }

    @PostMapping("/findAll")
    public String addFromFile(@ModelAttribute("file") MultipartFile file) {
        movieService.addFromFile(file);
        return "redirect:/movies/findAll";
    }
}
