package com.example.boostcom.model.dto;

import java.util.List;

public class PacketDto {

    private String name;
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
