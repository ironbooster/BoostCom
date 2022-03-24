package com.example.boostcom.web;

import com.example.boostcom.model.dto.binding.ContractProviderBindingDto;
import com.example.boostcom.model.dto.binding.ContractUserBindingDto;
import com.example.boostcom.model.entities.ContractProviderEntity;
import com.example.boostcom.model.entities.enums.CategoryEnum;
import com.example.boostcom.repository.*;
import com.example.boostcom.service.ContractProviderService;
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
import java.util.List;


@Controller
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    ContractUserRepository contractUserRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ContractProviderRepository contractProviderRepository;
    @Autowired
    ContractProviderService contractProviderService;
    @Autowired
    PacketRepository packetRepository;

    @ModelAttribute("contractProviderBindingDto")
    public ContractProviderBindingDto createContractProviderBinding() {
        return new ContractProviderBindingDto();
    }
    @ModelAttribute("contractUserBindingDto")
    public ContractUserBindingDto createContractUserBinding() {
        return new ContractUserBindingDto();
    }

    @GetMapping("/selection")
    public String contractSelection(){
        return "contract-select";
    }


    @GetMapping("/provider/add")
    public String addProviderContract(Model model){
        model.addAttribute("categories", CategoryEnum.values());
        return "add-provider-contract";
    }
    @PostMapping("/provider/add")
    public String addProviderContract(@Valid ContractProviderBindingDto contractProviderBindingDto,
                                      BindingResult bindingResult,
                                      RedirectAttributes redirectAttributes){

        contractProviderService.save(contractProviderBindingDto);
        return "redirect:/contracts/provider";
    }

    @GetMapping("/user/add")
    public String addUserContract(Model model){

        model.addAttribute("packetList",packetRepository.findAll());
        return "add-user-contract";
    }
    @PostMapping("/user/add")
    public String addUserContract(@Valid ContractUserBindingDto contractUserBindingDto,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){


        return "redirect:/contracts/user";
    }

    @GetMapping("/user")
    private String showUserContracts(Model model){
        model.addAttribute("userContracts",userRepository.findAll());
        return "user-contract-list";
    }
    @GetMapping("/provider")
    private String showProviderContracts(Model model){
        List<ContractProviderEntity> contractProviderEntities = contractProviderRepository.findAll();
        model.addAttribute("providerContracts",contractProviderRepository.findAll());
        return "provider-contract-list";
    }
}
