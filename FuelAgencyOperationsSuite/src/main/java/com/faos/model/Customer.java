package com.faos.model;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table
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

    @Column
    private String connectionType;

    @Column
    private String gender;

    @Column
    private String status;

    @Column
    private LocalDate registrationDate;

    @Column
    private LocalDate deactivationDate;

    @Column
    private String reasonForDeactivation;


}
