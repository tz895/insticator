package com.example.insticator.controller;

import com.example.insticator.model.Checkbox;
import com.example.insticator.service.CheckboxService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/checkbox")
public class CheckboxController {

    private CheckboxService checkboxService;

    public CheckboxController(CheckboxService checkboxService) {
        this.checkboxService = checkboxService;
    }

    @GetMapping("/create")
    public ModelAndView addCheckbox() {
        Checkbox checkbox = new Checkbox();
        ModelAndView modelAndView = new ModelAndView("/createCheckbox");
        modelAndView.addObject("checkbox",checkbox);
        return modelAndView;
    }

    @PostMapping("/create")
    public String addCheckbox(@Valid @ModelAttribute("Checkbox")Checkbox checkbox, BindingResult result, HttpServletRequest request) {
        if(result.hasErrors()) {
            return "Fail";
        }
        checkboxService.add(checkbox);

        return "Blank";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editCheckbox(@PathVariable("id") int id) {
        Checkbox checkbox = checkboxService.getById(id);
        ModelAndView modelAndView = new ModelAndView("/editCheckbox");
        modelAndView.addObject("checkbox",checkbox);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editCheckbox(@Valid @ModelAttribute("Checkbox")Checkbox checkbox, BindingResult result, HttpServletRequest request) {
        if(result.hasErrors()) {
            return "Fail";
        }
        checkboxService.update(checkbox);

        return "Blank";
    }

    @GetMapping("/delete/{id}")
    public String deleteCheckbox(@PathVariable("id") int id) {
        checkboxService.delete(id);

        return "Blank";
    }
}
