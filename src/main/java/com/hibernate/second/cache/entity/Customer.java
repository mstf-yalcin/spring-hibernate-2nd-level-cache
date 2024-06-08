package com.hibernate.second.cache.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;

@Data
@Entity
@Cacheable
@Cache(region = "customers", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @Cache(region = "address", usage = CacheConcurrencyStrategy.READ_WRITE)
    private List<com.hibernate.second.cache.entity.Address> address;
}
