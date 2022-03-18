package com.example.boostcom.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/packets")
public class PacketController {


    @GetMapping("/all")
    public String contractSelection(){
        return "packets";
    }
}
