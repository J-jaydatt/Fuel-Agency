package com.faos.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import com.faos.dto.CustomerDTO;
import com.faos.model.Customer;
import com.faos.service.CustomerService;

import jakarta.validation.Valid;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService service;
    
    private Optional<Customer> optionalCustomer;
    
    @GetMapping("/")
    public String get(){
        return "Menu_page";
    }
    
    @GetMapping("/customerDetails")
    public String findAll(Model model) {
    	List<Customer> customers = service.findAll();
        model.addAttribute("customers", customers);
        return "Customer_Details";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("customer", new Customer());
        return "index";  
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute("customer") Customer customer, Model model) {
        try {
            service. registerCustomer(customer);
            model.addAttribute("message", "Customer added successfully");
        } catch (Exception e) {
            model.addAttribute("message2", "Customer failed to add !!");
        }
        return "index";
    }


//    	System.out.println("2nd Register cutomer ,,,,,,,,,,,,,,,,,,,,"+customerDTO);
//        service.registerCustomer(customerDTO);
//        redirectAttributes.addFlashAttribute("message", "Customer added successfully!");
//        return "redirect:/register";
    }

//    @GetMapping("/editRedirect")
//    public String editRedirect(@RequestParam(value = "consumerId", required = false) String consumerId, Model model) {
//        model.addAttribute("consumerId", consumerId);
//        return "edit_customer";
//    }
//
//    @GetMapping("/find")
//    public String findByConsumerId(@RequestParam("id") Long id, Model model) {
//        optionalCustomer = service.findByConsumerId(id);
//
//        if (optionalCustomer.isEmpty()) {
//            model.addAttribute("message", "Customer not present");
//            return "edit_customer";
//        }
//
//        Customer customer = optionalCustomer.get();
//        if ("Deactivated".equalsIgnoreCase(customer.getStatus())) {
//            model.addAttribute("message", "Customer is deactivated");
//        }
//
//        model.addAttribute("customer", customer);
//        return "edit_customer";
//    }
//
//    @PostMapping("/activate")
//    public String activateCustomer(@RequestParam("consumerId") Long id, Model model) {
//
//        optionalCustomer = service.findByConsumerId(id);
//
//        if (optionalCustomer.isEmpty()) {
//            model.addAttribute("message", "Customer not found");
//            return "edit_customer";
//        }
//
//        Customer customer = optionalCustomer.get();
//        customer.setStatus("Active");
//        customer.setDeactivationDate(null);
//        customer.setReasonForDeactivation(null);
//
//        service.save(customer);
//        model.addAttribute("message", "Customer activated successfully");
//
//        System.out.println("End..........................");
//        return "edit_customer";
//    }
//
//    @PostMapping("/updateCustomer")
//    public String updateCustomer(@RequestParam("consumerId") Long id, @ModelAttribute CustomerDTO customerDTO, Model model) {
//        Customer updatedCustomer = service.updateCustomer(id, customerDTO);
//        model.addAttribute("customer", updatedCustomer);
//        model.addAttribute("message", "Customer updated successfully");
//        return "edit_customer";
//    }
//
//    @GetMapping("/deactivate")
//    public String deactivate() {
//        return "Deactivate_customer";
//    }
//
//    @PostMapping("/deactivate/customer")
//    public String deactivateCustomer(@RequestParam("consumerId") Long id,@RequestParam("reasonForDeactivation") String reason,Model model) {
//        Optional<Customer> optionalCustomer = service.findByConsumerId(id);
//        if (optionalCustomer.isEmpty()) {
//            model.addAttribute("message", "Customer not found");
//            return "Deactivate_customer";
//        }
//        Customer customer = optionalCustomer.get();
//        customer.setStatus("Deactivated");
//        customer.setDeactivationDate(LocalDate.now());
//        customer.setReasonForDeactivation(reason);
//
//        service.save(customer);
//        model.addAttribute("message", "Customer successfully deactivated");
//        return "Deactivate_customer";
//    }
//
//
//    @GetMapping("/delete")
//    public String delete(){
//        return "Remove_customer";
//    }
//
//    @PostMapping("/deleteCustomer")
//    public String deleteById(@RequestParam("consumerId") Long id, Model model) {
//
//        String result = service.deleteById(id);
//
//        if (result.equals("ok")) {
//            model.addAttribute("message", "Customer delete successfully");
//        } else {
//            model.addAttribute("message", "Customer Not Found");
//        }
//
//        System.out.println("Message: " + model.getAttribute("message"));
//        return "Remove_customer";
//    }
//
//    @DeleteMapping("/deleteCustomer/")
//    public String deleteBy(@RequestParam("consumerId") String id, Model model) {
//        String result = service.deleteById(Long.valueOf(id));
//        if ("ok".equals(result)) {
//            model.addAttribute("message", "Customer deleted successfully");
//        } else {
//            model.addAttribute("message", "Customer not found");
//        }
//        return "Customer_Details";
//    }
//
//    //Not used
//    @GetMapping("/count")
//    public ResponseEntity<String> countCustomers() {
//        long totalCustomers = service.countCustomers();
//        return new ResponseEntity<>("Total number of customers is: " + totalCustomers, HttpStatus.OK);
//    }
//
//


