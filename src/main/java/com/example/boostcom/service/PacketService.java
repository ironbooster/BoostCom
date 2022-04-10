package com.example.boostcom.service;

import com.example.boostcom.model.dto.binding.PacketBindingDto;

import java.util.List;

public interface PacketService {

    void savePacket(PacketBindingDto packetDto);
    void deletePacket(Long id);

}
