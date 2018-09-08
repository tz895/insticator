package com.example.insticator.controller;

import com.example.insticator.dao.MatricDao;
import com.example.insticator.model.Matric;
import com.example.insticator.model.wrappedclass.MatricInput;
import com.example.insticator.service.MatricService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/matric")
public class MatricController {

    private MatricService matricService;

    public MatricController(MatricService matricService) {
        this.matricService = matricService;
    }

    //    @GetMapping("/test")
//    public ModelAndView getMetric() {
//        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
//        List<String> options = new ArrayList<>(Arrays.asList("option1","option2","option3","option4","option5"));
//        ModelAndView modelAndView = new ModelAndView("/metric");
//        modelAndView.addObject("lists",list);
//        modelAndView.addObject("options",options);
//        return modelAndView;
//    }

    @GetMapping("/create")
    public ModelAndView addMatric() {

        MatricInput matricInput = new MatricInput();
        ModelAndView modelAndView = new ModelAndView("/createMatric");
        modelAndView.addObject("input",matricInput);
        return modelAndView;
    }

    @PostMapping("/create")
    public String addMatric(@Valid @ModelAttribute("MatricInput")MatricInput matricInput, BindingResult result, HttpServletRequest request) {
        if(result.hasErrors()) {
            return "Fail";
        }
        Matric matric = new Matric();
        matric.setContent(matricInput.getContent());
        matric.setTitle(matricInput.getTitle());
        matric.setRowOptions(matricInput.getRowOptions());
        matric.setColOptions(matricInput.getColOptions());
        matricService.add(matric);

        return "Blank";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editMatric(@PathVariable("id") int id) {
        Matric matric = matricService.getById(id);

        MatricInput matricInput = new MatricInput();
        matricInput.set(matric.getContent(),matric.getTitle(),
                matric.getRowOptions(),matric.getColOptions());
        matricInput.setMid(matric.getmId());
        ModelAndView modelAndView = new ModelAndView("/editMatric");
        modelAndView.addObject("input",matricInput);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editMatric(@Valid @ModelAttribute("MatricInput")MatricInput matricInput, BindingResult result, HttpServletRequest request) {
        if(result.hasErrors()) {
            return "Fail";
        }
        Matric matric = new Matric();
        matric.setContent(matricInput.getContent());
        matric.setTitle(matricInput.getTitle());
        matric.setRowOptions(matricInput.getRowOptions());
        matric.setColOptions(matricInput.getColOptions());
        matric.setmId(matricInput.getMid());
        matricService.update(matric);

        return "Blank";
    }

    @GetMapping("/delete/{id}")
    public String deleteMatric(@PathVariable("id") int id) {
        matricService.delete(id);

        return "Blank";
    }

}
