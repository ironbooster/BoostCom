package com.example.boostcom.model.dto;

import java.time.LocalDate;
import java.util.List;

public class ContractDto {

    private String provider;
    private LocalDate expireDate;
    private LocalDate startDate;
    private List<String> packets;


    public ContractDto setProvider(String provider) {
        this.provider = provider;
        return this;
    }

    public ContractDto setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
        return this;
    }

    public ContractDto setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public ContractDto setPackets(List<String> packets) {
        this.packets = packets;
        return this;
    }

    public String getProvider() {
        return provider;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public List<String> getPackets() {
        return packets;
    }
}
