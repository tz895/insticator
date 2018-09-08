package com.example.insticator.controller;

import com.example.insticator.model.*;
import com.example.insticator.service.CheckboxService;
import com.example.insticator.service.MatricService;
import com.example.insticator.service.PollService;
import com.example.insticator.service.TriviaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    TriviaService triviaService;
    PollService pollService;
    CheckboxService checkboxService;
    MatricService matricService;

    public AdminController(TriviaService triviaService, PollService pollService, CheckboxService checkboxService, MatricService matricService) {
        this.triviaService = triviaService;
        this.pollService = pollService;
        this.checkboxService = checkboxService;
        this.matricService = matricService;
    }

    @GetMapping("")
    public ModelAndView home(){
        List<Trivia> triviaList = triviaService.getAllTrivia();
        List<Poll> pollList = pollService.getAllPoll();
        List<Checkbox> checkboxList = checkboxService.getAllCheckbox();
        List<Matric> matricList = matricService.getAllMatric();

        ModelAndView modelAndView = new ModelAndView("/inventory");
        modelAndView.addObject("trivias",triviaList);
        modelAndView.addObject("polls",pollList);
        modelAndView.addObject("checkbox",checkboxList);
        modelAndView.addObject("matrics",matricList);

        return modelAndView;
    }
}
