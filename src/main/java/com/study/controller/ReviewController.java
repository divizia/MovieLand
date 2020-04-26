package com.study.controller;

import com.study.entity.Review;
import com.study.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public String findAll(Model model) {
        model.addAttribute("reviews", reviewService.findAll());
        return "tables/reviews";
    }

    @GetMapping("/addReview")
    public String addPage() {
        return "createPages/createReview";
    }

    @PostMapping("/addReview")
    public String add(@ModelAttribute("review") Review review) {
        reviewService.save(review);
        return "redirect:/reviews";
    }

    @GetMapping("/deleteReview/{id}")
    public String delete(@PathVariable("id") int id) {
        reviewService.deleteById(id);
        return "redirect:/reviews";
    }

    @GetMapping("/deleteAllReviews")
    public String deleteAll() {
        reviewService.deleteAll();
        return "redirect:/reviews";
    }

    @GetMapping("/updateReview/{id}")
    public String updatePage(@PathVariable("id") int id, Model model) {
        model.addAttribute("review", reviewService.findById(id));
        return "updatePages/updateReview";
    }

    @PostMapping("/updateReview")
    public String update(@ModelAttribute("review") Review review) {
        reviewService.save(review);
        return "redirect:/reviews";
    }

    @PostMapping("/reviews")
    public String addFromFile(@ModelAttribute("file") MultipartFile file) {
        reviewService.addFromFile(file);
        return "redirect:/reviews";
    }

  /*  @PostMapping("/addReview")
    public String add(@RequestParam String movie, @RequestParam String username, @RequestParam String review) {
        reviewService.save(new Review(movie, username, review));
        return "redirect:/reviews";
    }*/
}
