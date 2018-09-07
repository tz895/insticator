package com.example.insticator.controller;

import com.example.insticator.model.Checkbox;
import com.example.insticator.model.Poll;
import com.example.insticator.model.Trivia;
import com.example.insticator.model.User;
import com.example.insticator.service.CheckboxService;
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

    public AdminController(TriviaService triviaService, PollService pollService, CheckboxService checkboxService) {
        this.triviaService = triviaService;
        this.pollService = pollService;
        this.checkboxService = checkboxService;
    }

    @GetMapping("")
    public ModelAndView home(){
        List<Trivia> triviaList = triviaService.getAllTrivia();
        List<Poll> pollList = pollService.getAllPoll();
        List<Checkbox> checkboxList = checkboxService.getAllCheckbox();

        ModelAndView modelAndView = new ModelAndView("/inventory");
        modelAndView.addObject("trivias",triviaList);
        modelAndView.addObject("polls",pollList);
        modelAndView.addObject("checkbox",checkboxList);

        return modelAndView;
    }
}
