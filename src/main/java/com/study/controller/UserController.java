package com.study.controller;

import com.study.entity.User1;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String findAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "tables/users";
    }

    @GetMapping("/addUser")
    public String addPage() {
        return "createPages/createUser";
    }

    @PostMapping("/addUser")
    public String add(@ModelAttribute("user") User1 user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/deleteUser/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/deleteAllUsers")
    public String deleteAll() {
        userService.deleteAll();
        return "redirect:/users";
    }

    @GetMapping("/updateUser/{id}")
    public String updatePage(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "updatePages/updateUser";
    }

    @PostMapping("/updateUser")
    public String update(@ModelAttribute("user") User1 user) {
        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping("/users")
    public String addFromFile(@ModelAttribute("file") MultipartFile file) {
        userService.addFromFile(file);
        return "redirect:/users";
    }
}
