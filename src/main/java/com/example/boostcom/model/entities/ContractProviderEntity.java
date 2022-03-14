package com.example.boostcom.model.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "contract_providers")
public class ContractProviderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,name = "started")
    private LocalDate dateStarted;
    @Column(nullable = false,name = "deadline")
    private LocalDate dateExpire;
    @OneToOne(cascade = CascadeType.ALL)
    private ProviderEntity providerEntity;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ChannelEntity> channelEntityList;

    public ContractProviderEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public ContractProviderEntity setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
        return this;
    }

    public ContractProviderEntity setDateExpire(LocalDate dateExpire) {
        this.dateExpire = dateExpire;
        return this;
    }

    public ContractProviderEntity setProviderEntity(ProviderEntity providerEntity) {
        this.providerEntity = providerEntity;
        return this;
    }

    public ContractProviderEntity setChannelEntityList(List<ChannelEntity> channelEntityList) {
        this.channelEntityList = channelEntityList;
        return this;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDateStarted() {
        return dateStarted;
    }

    public LocalDate getDateExpire() {
        return dateExpire;
    }

    public ProviderEntity getProviderEntity() {
        return providerEntity;
    }

    public List<ChannelEntity> getChannelEntityList() {
        return channelEntityList;
    }
}
