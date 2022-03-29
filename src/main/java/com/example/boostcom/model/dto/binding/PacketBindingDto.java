package com.example.boostcom.model.dto.binding;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class PacketBindingDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private List<String> channels;


    public PacketBindingDto setChannels(List<String> channels) {
        this.channels = channels;
        return this;
    }

    public PacketBindingDto setName(String name) {
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
