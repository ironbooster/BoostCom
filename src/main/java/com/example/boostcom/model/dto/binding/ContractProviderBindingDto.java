package com.example.boostcom.model.dto.binding;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ContractProviderBindingDto {
    private String providerName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expireDate;
    private List<String> channels;


    public ContractProviderBindingDto setProviderName(String providerName) {
        this.providerName = providerName;
        return this;
    }

    public ContractProviderBindingDto setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
        return this;
    }

    public ContractProviderBindingDto setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public ContractProviderBindingDto setChannels(List<String> channels) {
        this.channels = channels;
        return this;
    }

    public String getProviderName() {
        return providerName;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public List<String> getChannels() {
        return channels;
    }
}


