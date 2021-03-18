package com.jiaming.blog.web;

import com.jiaming.blog.NotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
    @GetMapping("/")
    public String index() throws NotFoundException {
        // int i = 1/0;
        // String blog = null;

        // if (blog == null) {
        //     throw new NotFoundException("Page Not Found");
        // }
        return "index"; // Name of html tamplate
    }
}
