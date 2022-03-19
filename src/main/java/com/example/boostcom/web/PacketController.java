package com.example.boostcom.web;

import com.example.boostcom.repository.PacketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/packets")
public class PacketController {
    @Autowired
    PacketRepository packetRepository;

    @GetMapping("/all")
    public String contractSelection(Model model){
        model.addAttribute("packets",packetRepository.findAll());
        return "packets-list";
    }
}
