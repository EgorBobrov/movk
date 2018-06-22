package com.egobob.namegenerator.web.controller;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import com.egobob.namegenerator.nameprovider.NameProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @Autowired
    NameProvider nameProvider;

    @GetMapping("/")
    public String getIndexPage(Model model) {
        model.addAttribute("greeting", "Hello!");
        model.addAttribute("message", nameProvider.getName("american"));
        return "index";
    }
}
