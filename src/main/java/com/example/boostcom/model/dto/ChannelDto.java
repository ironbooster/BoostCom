package com.example.boostcom.model.dto;

import com.example.boostcom.model.entities.enums.CategoryEnum;

public class ChannelDto {

    private String name;
    private double price;
    private CategoryEnum category;



    public ChannelDto setName(String name) {
        this.name = name;
        return this;
    }

    public ChannelDto setPrice(double price) {
        this.price = price;
        return this;
    }

    public ChannelDto setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public CategoryEnum getCategory() {
        return category;
    }
}
