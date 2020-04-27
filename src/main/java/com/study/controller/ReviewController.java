package com.study.controller;

import com.study.entity.Review;
import com.study.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("reviews", reviewService.findAll());
        return "tables/reviews";
    }

    @GetMapping("/JSON")
    @ResponseBody
    public Iterable findAll() {
        return reviewService.findAll();
    }

    @GetMapping("/add")
    public String addPage() {
        return "createPages/createReview";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("review") Review review) {
        reviewService.save(review);
        return "redirect:/reviews/findAll";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        reviewService.deleteById(id);
        return "redirect:/reviews/findAll";
    }

    @GetMapping("/deleteAll")
    public String deleteAll() {
        reviewService.deleteAll();
        return "redirect:/reviews/findAll";
    }

    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable("id") int id, Model model) {
        model.addAttribute("review", reviewService.findById(id));
        return "updatePages/updateReview";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("review") Review review) {
        reviewService.save(review);
        return "redirect:/reviews/findAll";
    }

    @PostMapping("/findAll")
    public String addFromFile(@ModelAttribute("file") MultipartFile file) {
        reviewService.addFromFile(file);
        return "redirect:/reviews/findAll";
    }

    @PostMapping("/JSON")
    public String addFromJSON(@ModelAttribute("file") MultipartFile file) {
        reviewService.addFromJSON(file);
        return "redirect:/reviews/findAll";
    }

  /*  @PostMapping("/addReview")
    public String add(@RequestParam String movie, @RequestParam String username, @RequestParam String review) {
        reviewService.save(new Review(movie, username, review));
        return "redirect:/reviews";
    }*/
}
