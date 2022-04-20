package com.example.boostcom.web;

import com.example.boostcom.repository.ChannelRepository;
import com.example.boostcom.service.ContractProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/channels")
public class ChannelController {
    @Autowired
    ChannelRepository channelRepository;
    @Autowired
    ContractProviderService contractProviderService;

    @GetMapping("/view")
    public String getChannels(Model model){
        model.addAttribute("channels",channelRepository.findAll());
        return "channel-list";
    }
    @GetMapping("/discount")
    public String discountChannels(@RequestParam(value="Percentage") int discPercentage){
        contractProviderService.discountChannelsPrice(discPercentage);
        return "redirect:/channels/view";
    }
    @GetMapping("/increase")
      public String increaseChannels(@RequestParam(value="Percentage") int incPercentage){
          contractProviderService.increaseChannelsPrice(incPercentage);
          return "redirect:/channels/view";
      }
}
