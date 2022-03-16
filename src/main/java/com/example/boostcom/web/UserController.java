package com.example.boostcom.web;

import com.example.boostcom.model.dto.user.UserDto;
import com.example.boostcom.model.dto.user.UserRegisterDto;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {


    @ModelAttribute("userRegisterDto")
    public UserRegisterDto createRegistrationBinding() {return new UserRegisterDto();}
    @ModelAttribute("userDto")
    public UserDto createUserBinding() {return new UserDto();}

    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/register")
    public String registration(@Valid UserRegisterDto userRegisterDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "redirect:/user/register";
        }

        return "redirect:/user/login";
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/login")
    public String logging(@Valid UserDto userDto,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            return "redirect:/user/login";
        }

        return "redirect:/";
    }



}
