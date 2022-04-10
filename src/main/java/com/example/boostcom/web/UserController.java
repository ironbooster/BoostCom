package com.example.boostcom.web;

import com.example.boostcom.model.dto.user.UserDto;
import com.example.boostcom.model.dto.user.UserRegisterDto;
import com.example.boostcom.model.entities.UserEntity;
import com.example.boostcom.repository.UserRepository;
import com.example.boostcom.repository.UserRoleRepository;
import com.example.boostcom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public UserRoleRepository userRoleRepository;
    @Autowired
    public UserService userService;


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
    @GetMapping("/all")
    public String userList(Model model){
        model.addAttribute("users",userRepository.findAll());
        return "user-list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id){
         userService.deleteUser(id);
        return "redirect:/user/all";
    }
}
