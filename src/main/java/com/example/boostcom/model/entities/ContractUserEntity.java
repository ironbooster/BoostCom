package com.example.boostcom.model.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "contract_users")
public class ContractUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "started")
    private LocalDate dateStarted;
    @Column(name = "expired")
    private LocalDate dateExpire;
    @Column(nullable = false,name = "price")
    private double price;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "packet_user_contract",
            joinColumns = @JoinColumn(name = "contract_user_id"),
            inverseJoinColumns = @JoinColumn(name = "packet_id"))
    private List<PacketEntity> packetEntities;


    public ContractUserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public ContractUserEntity setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
        return this;
    }

    public ContractUserEntity setDateExpire(LocalDate dateExpire) {
        this.dateExpire = dateExpire;
        return this;
    }

    public ContractUserEntity setPrice(double price) {
        this.price = price;
        return this;
    }

    public ContractUserEntity setPacketEntities(List<PacketEntity> packetEntities) {
        this.packetEntities = packetEntities;
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

    public double getPrice() {
        return price;
    }

    public List<PacketEntity> getPacketEntities() {
        return packetEntities;
    }
}
