package com.example.boostcom.model.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contracts")
public class ContractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,name = "started")
    private LocalDate dateStarted;
    @Column(nullable = false,name = "deadline")
    private LocalDate dateExpire;
    @ManyToOne
    private ProviderEntity provider;
    @ManyToOne
    private PacketEntity packet;


    public ContractEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public ContractEntity setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
        return this;
    }

    public ContractEntity setDateDeadline(LocalDate dateDeadline) {
        this.dateExpire = dateDeadline;
        return this;
    }

    public ContractEntity setProvider(ProviderEntity provider) {
        this.provider = provider;
        return this;
    }

    public ContractEntity setPacket(PacketEntity packet) {
        this.packet = packet;
        return this;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDateStarted() {
        return dateStarted;
    }

    public LocalDate getDateDeadline() {
        return dateExpire;
    }

    public ProviderEntity getProvider() {
        return provider;
    }

    public PacketEntity getPacket() {
        return packet;
    }
}
