package com.example.insticator.controller;

import com.example.insticator.model.Poll;
import com.example.insticator.service.PollService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/poll")
public class PollController {
    private PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @GetMapping("/create")
    public ModelAndView addPoll() {
        Poll poll = new Poll();
        ModelAndView modelAndView = new ModelAndView("/createPoll");
        modelAndView.addObject("poll",poll);
        return modelAndView;
    }

    @PostMapping("/create")
    public String addPoll(@Valid @ModelAttribute("Poll")Poll poll, BindingResult result, HttpServletRequest request) {
        if(result.hasErrors()) {
            return "Fail";
        }
        pollService.add(poll);

        return "Blank";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editPoll(@PathVariable("id") int id) {
        Poll poll = pollService.getById(id);
        ModelAndView modelAndView = new ModelAndView("/editPoll");
        modelAndView.addObject("poll",poll);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editPoll(@Valid @ModelAttribute("Poll")Poll poll, BindingResult result, HttpServletRequest request) {
        if(result.hasErrors()) {
            return "Fail";
        }
        pollService.update(poll);

        return "Blank";
    }

    @GetMapping("/delete/{id}")
    public String deletePoll(@PathVariable("id") int id) {
        pollService.delete(id);

        return "Blank";
    }
}
