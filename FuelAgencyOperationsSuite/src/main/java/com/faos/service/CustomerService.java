package com.faos.service;
import java.util.List;
import java.util.Random;
import com.faos.model.Customer;
import com.faos.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class CustomerService
{

    @Autowired
    private CustomerRepository repositoryy;

    // Generates a unique 16-digit ID based on the current timestamp and random digits
    private Long generateUniqueDigitId() {
        long timestamp = System.currentTimeMillis();
        int randomDigits = new Random().nextInt(9000) + 1000;
        return Long.parseLong(timestamp + "" + randomDigits);
    }

    // Retrieves all customers
    public List<Customer> findAll() {
        return repositoryy.findAll();
    }

    // Registers a new customer
    public void registerCustomer(Customer customer)
    {
        repositoryy.save(customer); // Save the customer to the database
    }
}
//		modelMapper.addMappings(propertyMap);
//    	Customer customer = modelMapper.map(customerDTO, Customer.class);
//    	customer.setConsumerId(generateUniqueDigitId());
//    	customer.setStatus("Active");
//    	customer.setRegistrationDate(LocalDate.now());
//       	return repository.save(customer);

    
//    public Customer updateCustomer(Long id, CustomerDTO dto) {
//        Customer customer = repository.findByConsumerId(id)
//                .orElseThrow(() -> new RuntimeException("Customer not found"));
//
//        customer.setContactNumber(dto.getContactNumber());
//        customer.setEmail(dto.getEmail());
//        customer.setAddress(dto.getAddress());
//        customer.setConnectionType(dto.getConnectionType());
//        return repository.save(customer);
//    }
//
//    public Customer deactivateCustomer(Long id, String reason) {
//        Customer customer = repository.findByConsumerId(id)
//                .orElseThrow(() -> new RuntimeException("Customer not found"));
//        customer.setStatus("Inactive");
//        customer.setDeactivationDate(LocalDate.now());
//        customer.setReasonForDeactivation(reason);
//        return repository.save(customer);
//    }
//
//    public String deleteById(Long id) {
//        Optional<Customer> customer = repository.findById(id);
//
//        if (customer.isPresent()) {
//            repository.deleteById(id);
//            return "ok";
//        }
//
//        return "not found";
//    }
//
//
//    public long countCustomers() {
//        return repository.count();
//    }
//
//    public Customer save(Customer customer) {
//        return repository.save(customer);
//    }
//


