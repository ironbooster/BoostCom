package com.example.boostcom.service;

import com.example.boostcom.model.dto.binding.PacketBindingDto;
import com.example.boostcom.model.dto.view.PacketViewModel;

import java.util.List;

public interface PacketService {

    void save(PacketBindingDto packetDto);

    List<PacketViewModel> getAllPackets();
}
