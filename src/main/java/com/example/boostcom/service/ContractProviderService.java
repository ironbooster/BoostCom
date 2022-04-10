package com.example.boostcom.service;

import com.example.boostcom.model.dto.binding.ContractProviderBindingDto;

public interface ContractProviderService {

    void saveProviderContract(ContractProviderBindingDto contractProviderBindingDto);

    void deleteProviderContractById(long id);
    void discountChannelsPrice(int discPercentage);
    void increaseChannelsPrice(int incPercentage);
}
