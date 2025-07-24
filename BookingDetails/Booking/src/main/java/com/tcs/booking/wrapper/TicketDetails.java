package com.tcs.booking.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDetails {
    private String ticketNumber;
    private String passengerName;
    private Integer seatNumber;
    private String sourceDestination;
    private String flightName;
    private String flightNumber;
    private String travelClass;
    private Double amount;
    private Integer age;
    private String gender;
    private LocalDate travelDate;
    private LocalDateTime bookingTime;
    private String paymentStatus;
    private String TransactionId;




}
