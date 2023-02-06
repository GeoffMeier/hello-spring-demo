package org.launchcode.HelloSpring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello Spring";
//    }
//create handler that handles requests of the form /hello?name=LaunchCode
// @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
//
//    public String helloWithQueryParam(@RequestParam String name){
//return "Hello, " + name + "!";
//    }
//    // handles requests of the form /hello/LaunchCode
//
//    @GetMapping("{name}")
//
//    public String helloWithPathParam(@PathVariable String name){
//        return "Hello, " + name + "!";
//    }
    @RequestMapping(value="/hello", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, language);

        // For a bonus mission, students can change this response text to look nicer.
        // This is subjective, but students should be modifying the HTML of the response string.
    }


    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equalsIgnoreCase("English")) {
            greeting = "Hello";
        }
        else if (l.equalsIgnoreCase("french")) {
            greeting = "Bonjour";
        }
        else if (l.equalsIgnoreCase("italian")) {
            greeting = "Bonjourno";
        }
        else if (l.equalsIgnoreCase("spanish")) {
            greeting = "Hola";
        }
        else if (l.equalsIgnoreCase("german")) {
            greeting = "Hallo";
        }

        return greeting + " " + n;
    }



    @GetMapping("/form")
    public String helloForm(){

        return "<html>" +
                "<body>" +
                "<form action= 'hello' method= 'post'>" + // submit request to /hello
                "<input type = 'text' name='name'>"+
                "<input type = 'select' name='language'>" +
                "<input type= 'submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
