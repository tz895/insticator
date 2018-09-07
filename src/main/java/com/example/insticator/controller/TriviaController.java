package com.example.insticator.controller;

import com.example.insticator.model.TAnswer;
import com.example.insticator.model.Trivia;
import com.example.insticator.model.User;
import com.example.insticator.service.TriviaService;
import com.example.insticator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/trivia")
public class TriviaController {

    private TriviaService triviaService;
    private UserService userService;

    public TriviaController(TriviaService triviaService, UserService userService) {
        this.triviaService = triviaService;
        this.userService = userService;
    }


    @GetMapping("/create")
    public ModelAndView addTrivia() {
        Trivia trivia = new Trivia();

        ModelAndView modelAndView = new ModelAndView("/createTrivia");
        modelAndView.addObject("trivia",trivia);

        return modelAndView;
    }
    @PostMapping("/create")
    public String addTrivia(@Valid@ModelAttribute("Trivia")Trivia trivia, BindingResult result, HttpServletRequest request) {
        if(result.hasErrors()) {
            return "Fail";
        }

        triviaService.add(trivia);

        return "Blank";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editTrivia(@PathVariable("id") int id) {
        Trivia trivia = triviaService.getById(id);

        ModelAndView modelAndView = new ModelAndView("/editTrivia");
        modelAndView.addObject("trivia",trivia);

        return modelAndView;
    }

    @PostMapping("/edit")
    public String editTrivia(@Valid@ModelAttribute("Trivia")Trivia trivia, BindingResult result, HttpServletRequest request) {
        if(result.hasErrors()) {
            return "Fail";
        }

        triviaService.update(trivia);

        return "Blank";
    }

    @GetMapping("/delete/{id}")
    public String deleteTrivia(@PathVariable("id")int id) {
        triviaService.delete(id);

        return "Blank";
    }


}
