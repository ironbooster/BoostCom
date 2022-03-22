package com.example.boostcom.model.dto.binding;

import com.example.boostcom.model.dto.ChannelDto;
import com.example.boostcom.model.entities.enums.CategoryEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ContractProviderBindingDto {
    @NotNull
    private String providerName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expireDate;
    @NotNull
    private double contractPrice;
    @NotNull
    private List<String> channels;
    @NotNull
    private List<Double> channelPrices;
    @NotNull
    private List<CategoryEnum> category;

    public double getContractPrice() {
        return contractPrice;
    }

    public ContractProviderBindingDto setContractPrice(double contractPrice) {
        this.contractPrice = contractPrice;
        return this;
    }

    public List<CategoryEnum> getCategory() {
        return category;
    }

    public ContractProviderBindingDto setCategory(List<CategoryEnum> category) {
        this.category = category;
        return this;
    }

    public List<Double> getChannelPrices() {
        return channelPrices;
    }

    public ContractProviderBindingDto setChannelPrices(List<Double> channelPrices) {
        this.channelPrices = channelPrices;
        return this;
    }

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


