package com.modernisc.customers.model;

import javax.persistence.*;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Past;
import java.time.LocalDate;


@Entity
@Table(name = "TBL_CUSTOMERS")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
//    @NotEmpty
    private String firstName;

    @Column(nullable = false)
//    @NotEmpty
    private String lastName;

    @Column(nullable = false)
//    @NotEmpty
//    @Email
    private String email;
//
//    @Past
//    private LocalDate dayOfBirth;

//    @Column(nullable = false)
//    private String customerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public LocalDate getDayOfBirth() {
//        return dayOfBirth;
//    }
//
//    public void setDayOfBirth(LocalDate dayOfBirth) {
//        this.dayOfBirth = dayOfBirth;
//    }
//
//    public String getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(String customerId) {
//        this.customerId = customerId;
//    }
}
