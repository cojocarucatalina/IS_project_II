package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.model.RegistrationRequest;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String getUsers(Model model){
        List<UserDto> userDtos = userService.getAllUsers();
        model.addAttribute("title", "Users");
        model.addAttribute("users", userDtos);
        return "users";
    }

    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("/users/create")
    public String register(@RequestParam(value="registrationSuccess", required = false) String success, Model model){
        model.addAttribute("title","Register");
        model.addAttribute("regSuccess",success);
        model.addAttribute("user", new RegistrationRequest());
        return "users/create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") RegistrationRequest registrationRequest, RedirectAttributes redirectAttributes){

        UserDto userDto = userService.registerUser(registrationRequest);
        redirectAttributes.addAttribute("regSuccess","Succeees");
        return "redirect:/users";
    }

}
