package com.example.boostcom.model.dto.binding;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class ContractUserBindingDto {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expireDate;
    @NotNull
    private List<String> packetNames;
    @NotNull
    private List<String> channelNames;
    @NotNull
    private List<String> packetCategory;

    public LocalDate getStartDate() {
        return startDate;
    }

    public ContractUserBindingDto setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public ContractUserBindingDto setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
        return this;
    }

    public List<String> getPacketNames() {
        return packetNames;
    }

    public ContractUserBindingDto setPacketNames(List<String> packetNames) {
        this.packetNames = packetNames;
        return this;
    }

    public List<String> getChannelNames() {
        return channelNames;
    }

    public ContractUserBindingDto setChannelNames(List<String> channelNames) {
        this.channelNames = channelNames;
        return this;
    }

    public List<String> getPacketCategory() {
        return packetCategory;
    }

    public ContractUserBindingDto setPacketCategory(List<String> packetCategory) {
        this.packetCategory = packetCategory;
        return this;
    }
}
