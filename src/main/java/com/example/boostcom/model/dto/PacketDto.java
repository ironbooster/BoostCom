package com.example.boostcom.model.dto;

import com.example.boostcom.model.entities.enums.CategoryEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class PacketDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private List<String> channels;


    public PacketDto setChannels(List<String> channels) {
        this.channels = channels;
        return this;
    }

    public PacketDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public List<String> getChannels() {
        return channels;
    }
}
