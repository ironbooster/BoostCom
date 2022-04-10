package com.example.boostcom.service;

import com.example.boostcom.model.dto.binding.ContractProviderBindingDto;
import com.example.boostcom.model.dto.binding.ContractUserBindingDto;

public interface ContractUserService {
    void saveUserContract(ContractUserBindingDto contractUserBindingDto);
    void deleteUserContractById(Long id);
}
