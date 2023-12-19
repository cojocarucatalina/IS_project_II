package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Controller
public class HelloController {

    // handkes reuest at payh / hello
//    @GetMapping("hello")
//    @ResponseBody //plain text
//    public String hello(){
//        return "Hello, Spring";
//    }

//    @GetMapping("goodbye")
//    @ResponseBody //plain text
//    public String goodbye(){
//        return "Goodbye, Spring";
//    }

    // handles request of the form /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting",greeting);
        return "hello";
    }

    // handles /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name){
        String greeting = "Hello, "+ name + " !";
        return "hello";
    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Ana");
        names.add("Alex");
        names.add("Anda");
        model.addAttribute("names", names);
        return "hello-list";
    }


}









