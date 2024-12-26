package com.faos.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faos.dto.CustomerDTO;
import com.faos.model.Customer;
import com.faos.repo.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;
    
    private Long generateUniqueDigitId() {
        long timestamp = System.currentTimeMillis(); 
        int randomDigits = new Random().nextInt(9000) + 1000; 
        return Long.parseLong(timestamp + "" + randomDigits); 
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public Optional<Customer> findByConsumerId(Long id) {
        return repository.findByConsumerId(id);
    }

    public Customer registerCustomer(CustomerDTO customerDTO) {
    	ModelMapper modelMapper = new ModelMapper();
    	PropertyMap<CustomerDTO, Customer> propertyMap = new PropertyMap<CustomerDTO, Customer>() {

			@Override
			protected void configure() {
				skip(destination.getConsumerId());
				skip(destination.getStatus());
				skip(destination.getRegistrationDate());
				skip(destination.getDeactivationDate());
				skip(destination.getReasonForDeactivation());
			}
		};
		modelMapper.addMappings(propertyMap);
    	Customer customer = modelMapper.map(customerDTO, Customer.class);
    	customer.setConsumerId(generateUniqueDigitId());
    	customer.setStatus("Active");
    	customer.setRegistrationDate(LocalDate.now());
       	return repository.save(customer);
    }
    
    public Customer updateCustomer(Long id, CustomerDTO dto) {
        Customer customer = repository.findByConsumerId(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setContactNumber(dto.getContactNumber());
        customer.setEmail(dto.getEmail());
        customer.setAddress(dto.getAddress());
        customer.setConnectionType(dto.getConnectionType());
        return repository.save(customer);
    }
    
    public Customer deactivateCustomer(Long id, String reason) {
        Customer customer = repository.findByConsumerId(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setStatus("Inactive");
        customer.setDeactivationDate(LocalDate.now());
        customer.setReasonForDeactivation(reason);
        return repository.save(customer);
    }
    
    public String deleteById(Long id) {
        Optional<Customer> customer = repository.findById(id); 
        
        if (customer.isPresent()) { 
            repository.deleteById(id); 
            return "ok"; 
        }
        
        return "not found"; 
    }
    
    
    public long countCustomers() {
        return repository.count();
    }
    
    public Customer save(Customer customer) {
        return repository.save(customer);
    }


}
