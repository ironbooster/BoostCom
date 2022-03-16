package com.example.boostcom.web;

import com.example.boostcom.model.dto.binding.ContractProviderBindingDto;
import com.example.boostcom.model.dto.user.UserRegisterDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;

@Controller
@RequestMapping("/contracts")
public class ContractController {

    @ModelAttribute("contractProviderBindingDto")
    public ContractProviderBindingDto createRegistrationBinding() {
        return new ContractProviderBindingDto();
    }

    @GetMapping("/selection")
    public String contractSelection(){
        return "contract-select";
    }

    @GetMapping("/provider/add")
    public String addProviderContract(Model model){
        model.addAttribute("localDate", Instant.now());
        return "add-provider-contract";
    }
    @PostMapping("/provider/add")
    public String addProviderContract(ContractProviderBindingDto
                                                  contractProviderBindingDto){

        return "redirect:/contracts/selection";
    }


}
