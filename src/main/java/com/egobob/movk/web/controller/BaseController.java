package com.egobob.movk.web.controller;

import com.egobob.movk.authorization.VkAuthorizer;
import com.egobob.movk.urlprovider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @Autowired
    UrlProvider urlProvider;

    @GetMapping("/")
    public String getIndexPage(Model model) {
        model.addAttribute("greeting", "Hello!");
        model.addAttribute("message", urlProvider.getUrl());
        return "index";
    }
}
