package com.example.boostcom.service;

import com.example.boostcom.model.dto.binding.PacketBindingDto;

import java.util.List;

public interface PacketService {

    void savePacket(PacketBindingDto packetDto);
    List<Double> getPacketPrice();
    void deletePacket(Long id);

}
