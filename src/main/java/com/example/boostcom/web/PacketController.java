package com.example.boostcom.web;

import com.example.boostcom.model.dto.binding.PacketBindingDto;
import com.example.boostcom.repository.ChannelRepository;
import com.example.boostcom.repository.PacketRepository;
import com.example.boostcom.service.PacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/packets")
public class PacketController {
    @Autowired
    PacketRepository packetRepository;
    @Autowired
    ChannelRepository channelRepository;
    @Autowired
    PacketService packetService;

    @ModelAttribute("packetDto")
    public PacketBindingDto createPacketDto() {
        return new PacketBindingDto();
    }

    @GetMapping("/all")
    public String contractSelection(Model model){
        model.addAttribute("packets",packetRepository.findAll());
        //model.addAttribute("packetPrice",);
        //tuk trqbva i da sloja sumata na kanalite v paketa ;)
        return "packets-list";
    }

    @GetMapping("/add")
    public String createPacket(Model model){
        model.addAttribute("channels",channelRepository.findAll());
        return "add-channel-packet";
    }

    @PostMapping("/add")
    public String createPacket(@Valid PacketBindingDto packetDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){

        packetService.save(packetDto);
        return "redirect:/packets/all";
    }
}
