package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
public class HelloController {

    //    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(value = "hello",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name;
        model.addAttribute("greeting", greeting);
        return "Hello " + name;
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")

    public String helloWithPathParam(@PathVariable String name,Model model) {
        String greeting = "Hello " + name;

        model.addAttribute("greeting", greeting);
        return "Hello";
    }


    @GetMapping("/form")

    public String helloForm() {
        return "form";
    }
    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Geoff");
        names.add("Tyler");
        names.add("Carter");
        model.addAttribute("names",names);
        return "hello-list";
    }

}