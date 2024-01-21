package com.crudelearning.cruddemo.controllers;

import com.crudelearning.cruddemo.model.ServiceUsers;
import com.crudelearning.cruddemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateController {

    private UserService userService;

    public CreateController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create")
    public String create(){
        return "create";
    }

    @PostMapping("/create")
    public String createNewUser(@ModelAttribute ServiceUsers serviceUsers, Model model){
        System.out.println(serviceUsers.getFirstName());
        System.out.println(serviceUsers.getLastName());
        System.out.println(serviceUsers.getRole());
        System.out.println(serviceUsers.getId());
        model.addAttribute("message", userService.create(serviceUsers));
        return "create";
    }
}
