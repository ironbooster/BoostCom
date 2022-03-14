package com.example.boostcom.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="packets")
public class PacketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<ChannelEntity> channels;

    public PacketEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public PacketEntity setName(String name) {
        this.name = name;
        return this;
    }

    public PacketEntity setChannels(List<ChannelEntity> channels) {
        this.channels = channels;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ChannelEntity> getChannels() {
        return channels;
    }
}
