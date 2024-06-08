package com.hibernate.second.cache;

import com.hibernate.second.cache.entity.Address;
import com.hibernate.second.cache.entity.Customer;
import com.hibernate.second.cache.repository.AddressRepository;
import com.hibernate.second.cache.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class CacheApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }

    private final CustomerRepository customerRepository;

    public CacheApplication(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) {

        Address address = new Address();
        address.setCity("Istanbul");

        Address address2 = new Address();
        address2.setCity("Ankara");

        Customer customer = new Customer();
        customer.setName("Customer1");
        address.setCustomer(customer);

        Customer customer2 = new Customer();
        customer2.setName("Customer2");
        address2.setCustomer(customer2);

        customer.setAddress(Collections.singletonList(address));
        customer2.setAddress(Collections.singletonList(address2));

        customerRepository.saveAll(List.of(customer, customer2));
    }
}
