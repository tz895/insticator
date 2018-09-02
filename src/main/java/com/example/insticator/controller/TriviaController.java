package com.example.insticator.controller;

import com.example.insticator.model.Trivia;
import com.example.insticator.service.TriviaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping("/create")
    public ModelAndView addProduct() {
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
