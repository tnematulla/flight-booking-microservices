package com.tcs.booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookingReference;
    private Long flightId;
    private LocalDate travelDate;
    private LocalDateTime bookingTime;

    @NotNull(message = "First name must not be null")
    private String firstName;
    private String lastName;
    private Integer age;
    private String gender;
    private String travelClass;
    private Integer seatNumber;

    private Double amount;
    private String method;
    private String status;
    private String transactionId;
    private String cardNumber;
    private String expiryDate;
    private String cvv;

}
