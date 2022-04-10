package com.example.boostcom.model.entities;

import com.example.boostcom.model.entities.enums.CategoryEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Entity
@Table(name="channels")
public class ChannelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String channelName;
    @Column(nullable = false)
    private double price;
    @Enumerated(EnumType.STRING)
    private CategoryEnum channelCategoryEnum;


    public ChannelEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public ChannelEntity setChannelName(String channelName) {
        this.channelName = channelName;
        return this;
    }

    public ChannelEntity setPrice(double price) {
        this.price = price;
        return this;
    }

    public ChannelEntity setChannelCategoryEnum(CategoryEnum channelCategoryEnum) {
        this.channelCategoryEnum = channelCategoryEnum;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getChannelName() {
        return channelName;
    }

    public double getPrice() {
        return price;
    }


    public CategoryEnum getChannelCategoryEnum() {
        return channelCategoryEnum;
    }
}
