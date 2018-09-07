package com.example.insticator.controller;

import com.example.insticator.model.User;
import com.example.insticator.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/index")
public class HomeController {

    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ModelAndView home(){
        User user = new User();

        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("user",user);

        return modelAndView;
    }

    @PostMapping("")
    public String home(@Valid@ModelAttribute("User") User user, BindingResult result, HttpServletRequest request) {
        if(result.hasErrors()) {
            return "Fail";
        }

        userService.add(user);

        return "redirect:/main/random/"+user.getuId();
    }
}
