package com.example.insticator.controller;

import com.example.insticator.model.Trivia;
import com.example.insticator.service.TriviaService;
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

    public TriviaController(TriviaService triviaService) {
        this.triviaService = triviaService;
    }

    @GetMapping("/random/{uId}")
    public ModelAndView getRandom(@PathVariable(value = "uId")int uid) {
        Trivia trivia = triviaService.getById(uid);
        ModelAndView modelAndView = new ModelAndView("/trivia");
        modelAndView.addObject("trivia",trivia);

        return modelAndView;
    }


    @RequestMapping("/create")
    public ModelAndView addTrivia() {
        Trivia trivia = new Trivia();

        ModelAndView modelAndView = new ModelAndView("/createTrivia");
        modelAndView.addObject("trivia",trivia);

        return modelAndView;

    }
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String addTrivia(@Valid@ModelAttribute("Trivia")Trivia trivia, BindingResult result, HttpServletRequest request) {
        if(result.hasErrors()) {
            return "Fail";
        }

        triviaService.add(trivia);

        return "home";
    }


}
