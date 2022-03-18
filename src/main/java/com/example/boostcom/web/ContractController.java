package com.example.boostcom.web;

import com.example.boostcom.model.dto.binding.ContractProviderBindingDto;
import com.example.boostcom.model.dto.binding.ContractUserBindingDto;
import com.example.boostcom.model.dto.user.UserRegisterDto;
import com.example.boostcom.model.entities.enums.CategoryEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/contracts")
public class ContractController {

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
    public String addProviderContract(ContractProviderBindingDto
                                                  contractProviderBindingDto){

        return "redirect:/contracts/selection";
    }

    @GetMapping("/user/add")
    public String addUserContract(Model model){

        return "add-user-contract";
    }
    @PostMapping("/user/add")
    public String addUserContract(ContractUserBindingDto
                                              contractUserBindingDto){

        return "redirect:/contracts/selection";
    }


}
