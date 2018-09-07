package com.example.insticator.controller;

import com.example.insticator.model.*;
import com.example.insticator.model.wrappedclass.CheckboxAnswer;
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

    @GetMapping("test/checkbox/{uid}")
    public ModelAndView test(@PathVariable(value = "uId")int uid) {
        Checkbox checkbox =  checkboxService.getRandom(uid);
        return getRandomCheckbox(checkbox,uid);
    }

    @GetMapping("/random/{uId}")
    public ModelAndView getRandom(@PathVariable(value = "uId")int uid) {
        Trivia trivia = triviaService.getRandom(uid);
        Poll poll = pollService.getRandom(uid);
        Checkbox checkbox = checkboxService.getRandom(uid);


        if(trivia == null && poll == null && checkbox == null) {
            ModelAndView modelAndView = new ModelAndView("/finish");
            return modelAndView;
        }

        ModelAndView cur = null;

        Random ran = new Random();

        while(cur == null) {
            int random = ran.nextInt(3);
            switch (random) {
                case 0:
                    cur = trivia != null ? getRandomTrivia(trivia,uid) : null;
                    break;
                case 1:
                    cur = checkbox != null ? getRandomCheckbox(checkbox,uid) : null;
                    break;
                case 2:
                    cur = poll != null ? getRandomPoll(poll,uid) : null;
                    break;
                default:
                    cur = null;
                    break;
            }
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

    public ModelAndView getRandomCheckbox(Checkbox checkbox,int uid) {
        Integer answer = null;
        ModelAndView modelAndView = new ModelAndView("/checkbox");

        CheckboxAnswer cAnswer = new CheckboxAnswer(checkbox.getValidAnswer());

        modelAndView.addObject("checkbox",checkbox);
        modelAndView.addObject("answerArray",cAnswer);
        modelAndView.addObject("uId",uid);
        modelAndView.addObject("cId",checkbox.getcId());

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

    @PostMapping("/next/checkbox/{uId}/{cId}")
    public String getNextCheckbox(@PathVariable(value = "uId")int uid, @PathVariable(value = "cId")int cid, @Valid @ModelAttribute("answerArray") CheckboxAnswer cAnswer) {
        String s = String.join(" ",cAnswer.getAnswers());
        checkboxService.build(cid,uid,s);
        return "redirect:/main/random/"+ uid;
    }
}
