package com.faos.model;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Customer {

	@Id
    @Column(unique = true, nullable = false, length = 17)
    private Long consumerId;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 150, nullable = false)
    private String address;

    @NotNull
    @Column(length = 10)
    private String contactNumber;

    @NotNull
    @Column(length = 50)
    private String email;
    
    private String connectionType;
    private String gender;
    
    private String status;
    private LocalDate registrationDate;
    private LocalDate deactivationDate;
    private String reasonForDeactivation;
}
