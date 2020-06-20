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
    public String home(){
        return "guestview";
    }




        @RequestMapping("/login")
        public String login(){
            return "login";
        }
        @GetMapping("/signup")
        public String signup(Model model){
            model.addAttribute("user", new User());
            return "signup";
        }
        @PostMapping("/processsignup")
        public String processSignup(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
            model.addAttribute("user", user);
            if (result.hasErrors()) {
                return "signup";
            } else {
                model.addAttribute("message", "You have successfully created an account!");
                user.setEnabled(true);
                Role role = new Role(user.getUsername(), "ROLE_USER");
                Set<Role> roles = new HashSet<Role>();
                roles.add(role);

                roleRepository.save(role);
                userRepository.save(user);
            }
            return "redirect:/login";
        }


        @RequestMapping("/logout")
        public String logout(){
            return "redirect:/login?logout=true";
        }


}
