package com.study.controller;

import com.study.entity.User1;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "tables/users";
    }

    @GetMapping("/JSON")
    @ResponseBody
    public Iterable findAll() {
        return userService.findAll();
    }

    @GetMapping("/add")
    public String addPage() {
        return "createPages/createUser";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("user") User1 user) {
        userService.save(user);
        return "redirect:/users/findAll";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/users/findAll";
    }

    @GetMapping("/deleteAll")
    public String deleteAll() {
        userService.deleteAll();
        return "redirect:/users/findAll";
    }

    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "updatePages/updateUser";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user") User1 user) {
        userService.save(user);
        return "redirect:/users/findAll";
    }

    @PostMapping("/findAll")
    public String addFromFile(@ModelAttribute("file") MultipartFile file) {
        userService.addFromFile(file);
        return "redirect:/users/findAll";
    }
}
