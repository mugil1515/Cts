package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

   @GetMapping("/")
   public String home(Model model) {
      model.addAttribute("message", "Welcome to Spring Web with Maven!");
      return "index";
   }
}
