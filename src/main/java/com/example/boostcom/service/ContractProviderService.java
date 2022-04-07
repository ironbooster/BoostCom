package com.example.boostcom.service;

import com.example.boostcom.model.dto.binding.ContractProviderBindingDto;

public interface ContractProviderService {

    void save(ContractProviderBindingDto contractProviderBindingDto);

    void deleteProviderContractById(long id);
}
