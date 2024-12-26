package com.faos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDTO {

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 50, message = "Invalid name length")
    @Pattern(regexp = "^[A-Za-z\\s'-]+$", message = "Name must contain only alphabets, spaces, hyphens, or apostrophes")
    private String name;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @NotBlank(message = "Contact number can't be Empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid contact number")
    private String contactNumber;

    @Email(message = "Invalid email address")
    @NotBlank(message = "Email can't be Empty")
    private String email;
    
    @NotBlank(message="Connection Type is required")
    private String connectionType;
    
    @NotBlank(message="Gender is required")
    private String gender;
}
