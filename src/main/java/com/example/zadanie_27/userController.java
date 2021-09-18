package com.example.zadanie_27;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class userController {

    private UserRepository userRepository;

    public userController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<User> userList = userRepository.findAll();
        model.addAttribute("userList", userList);
        return "home";
    }


    @GetMapping("/add")
    public String add(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "userAdd";
    }

    @PostMapping("/add")
    public String add(User user) {
        userRepository.save(user);
        return "redirect:/";
    }


}
