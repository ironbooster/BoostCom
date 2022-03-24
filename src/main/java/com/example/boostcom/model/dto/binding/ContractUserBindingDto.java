package com.example.boostcom.model.dto.binding;

import net.bytebuddy.implementation.bind.annotation.Empty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class ContractUserBindingDto {
    @NotEmpty
    private String username;
    @NotEmpty
    private List<String> packets;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateStarted;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateExpire;


    public String getUsername() {
        return username;
    }

    public ContractUserBindingDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public List<String> getPackets() {
        return packets;
    }

    public ContractUserBindingDto setPackets(List<String> packets) {
        this.packets = packets;
        return this;
    }

    public LocalDate getDateStarted() {
        return dateStarted;
    }

    public ContractUserBindingDto setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
        return this;
    }

    public LocalDate getDateExpire() {
        return dateExpire;
    }

    public ContractUserBindingDto setDateExpire(LocalDate dateExpire) {
        this.dateExpire = dateExpire;
        return this;
    }
}



