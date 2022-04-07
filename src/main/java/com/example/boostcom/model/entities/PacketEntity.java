package com.example.boostcom.model.entities;

import com.example.boostcom.model.entities.enums.CategoryEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="packets")
public class PacketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CategoryEnum categoryEnum;
    @Column(nullable = false)
    private String name;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "packet_channel",
            joinColumns = @JoinColumn(name = "packet_id"),
            inverseJoinColumns = @JoinColumn(name = "channel_id"))
    private List<ChannelEntity> channels;


    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public PacketEntity setCategoryEnum(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
        return this;
    }

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
