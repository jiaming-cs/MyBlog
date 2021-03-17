package com.jiaming.blog.web;

import com.jiaming.blog.NotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {
    @GetMapping("/{name}/{id}")
    public String index(@PathVariable String name, @PathVariable Integer id) throws NotFoundException {
        // int i = 1/0;
        // String blog = null;

        // if (blog == null) {
        //     throw new NotFoundException("Page Not Found");
        // }
        return "Index"; // Name of html tamplate
    }
}
