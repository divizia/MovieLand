package com.study.controller;

import com.study.entity.Movie;
import com.study.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public String findAll(Model model) {
        model.addAttribute("movies", movieService.findAll());
        return "tables/movies";
    }

    @GetMapping("/addMovie")
    public String addPage() {
        return "createPages/createMovie";
    }

    @PostMapping("/addMovie")
    public String add(@ModelAttribute("movies") Movie movie) {
        movieService.save(movie);
        return "redirect:/movies";
    }

    @GetMapping("/deleteMovie/{id}")
    public String delete(@PathVariable("id") int id) {
        movieService.deleteById(id);
        return "redirect:/movies";
    }

    @GetMapping("/deleteAllMovies")
    public String deleteAll() {
        movieService.deleteAll();
        return "redirect:/movies";
    }

    @GetMapping("/updateMovie/{id}")
    public String updatePage(@PathVariable("id") int id, Model model) {
        model.addAttribute("movie", movieService.findById(id));
        return "updatePages/updateMovie";
    }

    @PostMapping("/updateMovie")
    public String update(@ModelAttribute("movie") Movie movie) {
        movieService.save(movie);
        return "redirect:/movies";
    }
}
