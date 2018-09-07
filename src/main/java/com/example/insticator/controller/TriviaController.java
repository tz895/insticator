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

    @GetMapping("/random/{uId}")
    public ModelAndView getRandom(@PathVariable(value = "uId")int uid) {
        Trivia trivia = triviaService.getRandom(uid);
        if(trivia == null) {
            ModelAndView modelAndView = new ModelAndView("/finish");
            return modelAndView;
        }
        Integer answer = null;
        ModelAndView modelAndView = new ModelAndView("/trivia");
        TAnswer tAnswer = new TAnswer();
        modelAndView.addObject("trivia",trivia);
        modelAndView.addObject("answer",tAnswer);
        modelAndView.addObject("uId",uid);
        modelAndView.addObject("tId",trivia.gettId());

        return modelAndView;
    }

    @PostMapping("/next/{uId}/{tId}")
    public String getNext(@PathVariable(value = "uId")int uid, @PathVariable(value = "tId")int tid, @Valid@ModelAttribute("answer")TAnswer tAnswer) {
        triviaService.build(tid,uid,tAnswer.getAnswer());
        return "redirect:/trivia/random/"+ uid;
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


}
