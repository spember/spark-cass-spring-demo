package org.pember.sparkdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MiscController {

    @RequestMapping("/")
    public String index() {
        System.out.println("In home!");
        return "forward:index.html";
    }
}
