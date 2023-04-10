package com.fitness.controller;

import com.fitness.controller.main.Attributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class IndexCont extends Attributes {

    @GetMapping
    public String index1(Model model) {
        AddAttributesIndex(model);
        return "index";
    }

    @GetMapping("/index")
    public String index2(Model model) {
        AddAttributesIndex(model);
        return "index";
    }
}
