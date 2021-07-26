package com.xxx.noticeproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class DepartmentViewController {
    @GetMapping("/notice/list")
    public String noticeView(){
        return "index";
    }

    @GetMapping("/notice/detail/{id}")
    public ModelAndView noticeDetailView(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("detail");
        modelAndView.addObject("id",id);
        return modelAndView;
    }

    @GetMapping("/notice/modify/{id}")
    public ModelAndView noticeModifyView( @PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("modify");
        modelAndView.addObject("id",id);
        return modelAndView;
    }

    @GetMapping("/notice/create")
    public String noticeCreateView(){
        return "create";
    }

}
