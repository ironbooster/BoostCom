package com.example.boostcom.web;

import com.example.boostcom.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/channels")
public class ChannelController {
    @Autowired
    ChannelRepository channelRepository;

    @GetMapping("/view")
    public String getChannels(Model model){
        model.addAttribute("channels",channelRepository.findAll());
        return "channel-list";
    }
}
