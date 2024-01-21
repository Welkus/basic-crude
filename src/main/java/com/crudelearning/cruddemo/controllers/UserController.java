package com.crudelearning.cruddemo.controllers;

import com.crudelearning.cruddemo.model.ServiceUsers;
import com.crudelearning.cruddemo.service.UserFilter;
import com.crudelearning.cruddemo.DAO.UserRepository;
import com.crudelearning.cruddemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/read")
    public String read(Model model){
        List<ServiceUsers> serviceUsersList = userRepository.findAll();
        model.addAttribute("users", serviceUsersList);
        return "read";
    }

    @PostMapping("/read")
    public String search(@ModelAttribute UserFilter userFilter, Model model){
        List<ServiceUsers> serviceUsersList = userService.filterUser(userFilter);
        model.addAttribute("users",serviceUsersList);
        return "read";

    }

}
