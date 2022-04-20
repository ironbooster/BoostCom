package com.example.boostcom.web;

import com.example.boostcom.model.dto.binding.PacketBindingDto;
import com.example.boostcom.model.entities.PacketEntity;
import com.example.boostcom.repository.ChannelRepository;
import com.example.boostcom.repository.PacketRepository;
import com.example.boostcom.service.PacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
        List<PacketEntity> packetEntities = packetRepository
                .findAll()
                .stream()
                .filter(packetEntity -> !packetEntity.getChannels().isEmpty())
                .collect(Collectors.toList());
        model.addAttribute("packets",packetEntities);
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

        packetService.savePacket(packetDto);
        return "redirect:/packets/all";
    }
    @GetMapping("/delete/{id}")
    public String deletePacket(@PathVariable(name = "id") Long id){

        packetService.deletePacket(id);
        return "redirect:/packets/all";
    }
}
