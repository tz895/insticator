package com.example.insticator.controller;

import com.example.insticator.model.PAnswer;
import com.example.insticator.model.Poll;
import com.example.insticator.model.TAnswer;
import com.example.insticator.model.Trivia;
import com.example.insticator.service.CheckboxService;
import com.example.insticator.service.PollService;
import com.example.insticator.service.TriviaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Random;

@Controller
@RequestMapping("/main")
public class MainController {

    private TriviaService triviaService;
    private PollService pollService;
    private CheckboxService checkboxService;

    public MainController(TriviaService triviaService, PollService pollService, CheckboxService checkboxService) {
        this.triviaService = triviaService;
        this.pollService = pollService;
        this.checkboxService = checkboxService;
    }

    @GetMapping("/random/{uId}")
    public ModelAndView getRandom(@PathVariable(value = "uId")int uid) {
        Trivia trivia = triviaService.getRandom(uid);
        Poll poll = pollService.getRandom(uid);


        if(trivia == null && poll == null) {
            ModelAndView modelAndView = new ModelAndView("/finish");
            return modelAndView;
        }

        ModelAndView cur = getRandomTrivia(trivia,uid);

        Random ran = new Random();

        if(ran.nextInt(1) == 0 && poll != null) {
            cur = getRandomPoll(poll,uid);
        }

        return cur;
    }

    public ModelAndView getRandomTrivia(Trivia trivia,int uid) {
        Integer answer = null;
        ModelAndView modelAndView = new ModelAndView("/trivia");
        TAnswer tAnswer = new TAnswer();
        modelAndView.addObject("trivia",trivia);
        modelAndView.addObject("answer",tAnswer);
        modelAndView.addObject("uId",uid);
        modelAndView.addObject("tId",trivia.gettId());

        return modelAndView;
    }

    public ModelAndView getRandomPoll(Poll poll,int uid) {
        Integer answer = null;
        ModelAndView modelAndView = new ModelAndView("/poll");
        PAnswer pAnswer = new PAnswer();
        modelAndView.addObject("poll",poll);
        modelAndView.addObject("answer",pAnswer);
        modelAndView.addObject("uId",uid);
        modelAndView.addObject("pId",poll.getpId());

        return modelAndView;
    }

    @PostMapping("/next/trivia/{uId}/{tId}")
    public String getNextTrivia(@PathVariable(value = "uId")int uid, @PathVariable(value = "tId")int tid, @Valid @ModelAttribute("answer")TAnswer tAnswer) {
        triviaService.build(tid,uid,tAnswer.getAnswer());
        return "redirect:/main/random/"+ uid;
    }

    @PostMapping("/next/poll/{uId}/{pId}")
    public String getNextPoll(@PathVariable(value = "uId")int uid, @PathVariable(value = "pId")int pid, @Valid @ModelAttribute("answer")PAnswer pAnswer) {
        pollService.build(pid,uid,pAnswer.getAnswer());
        return "redirect:/main/random/"+ uid;
    }
}
