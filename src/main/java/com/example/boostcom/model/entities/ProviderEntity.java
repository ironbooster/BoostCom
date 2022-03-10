package com.example.boostcom.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="providers")
public class ProviderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String providerName;


    public ProviderEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public ProviderEntity setName(String name) {
        this.providerName = name;
        return this;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return providerName;
    }

}
