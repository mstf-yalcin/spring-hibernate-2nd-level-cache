package com.hibernate.second.cache.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Data
@Entity
@Cacheable
@Cache(region = "address", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Address {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String city;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private com.hibernate.second.cache.entity.Customer customer;
}
