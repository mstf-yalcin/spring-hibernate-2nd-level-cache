package com.hibernate.second.cache.repository;

import com.hibernate.second.cache.entity.Address;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.List;

import static org.hibernate.jpa.HibernateHints.HINT_CACHEABLE;

public interface AddressRepository extends JpaRepository<Address, Long> {
    @Override
    @QueryHints(value = {@QueryHint(name = HINT_CACHEABLE, value = "true")})
    List<Address> findAll();
}
