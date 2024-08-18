package com.jalal.deploytest.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeployController {

    @GetMapping({"/","/home"})
    public String deployHome(Model model) {
        model.addAttribute("name","Motaleb Jalal");
        return "index";
    }


}
