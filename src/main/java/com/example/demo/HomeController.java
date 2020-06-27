package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping("/")
    public String guest(){
        return "guestview";
    }

    @RequestMapping("/user")
    public String user(){
        return "userview";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "adminview";
    }

    @RequestMapping("/logout")
    public String logout(){
            return "redirect:/login?logout=true";
        }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }


}
