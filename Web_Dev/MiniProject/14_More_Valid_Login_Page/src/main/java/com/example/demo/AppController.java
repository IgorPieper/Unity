package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String getForm(Model model){
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @GetMapping("/result")
    public String getResult(){
        return "result";
    }

    @PostMapping("/handleSubmit")
    public String handleSubmit(@Valid User user, BindingResult result){
        if (user.getFirstName().equals(user.getLastName())) result.rejectValue("lastName", "", "Please enter valid data");
        if (result.hasErrors()) return "sign-up";
        return "redirect:/result";
    }
}

