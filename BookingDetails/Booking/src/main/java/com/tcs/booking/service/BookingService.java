package com.tcs.booking.service;

import com.tcs.booking.Exceptions.ResourceNotFoundException;
import com.tcs.booking.entity.Booking;
import com.tcs.booking.entity.Flights;
import com.tcs.booking.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookingService {
    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private RestTemplate restTemplate;

    public Booking createBooking(Booking booking) {
        // Fetch flight details
        Flights flight = restTemplate.getForObject(
                "http://FLIGHT-SERVICE/api/flights/" + booking.getFlightId(),
                Flights.class);
//        if (flight == null) {
//            throw new ResourceNotFoundException("Flight not found for ID: " + booking.getFlightId());
//        }



            booking.setAmount(flight.getPrice());
            booking.setBookingReference("TICK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
            booking.setTransactionId("TXN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
            booking.setBookingTime(LocalDateTime.now());
            booking.setSeatNumber((int) (Math.random() * 280) + 1);
            return bookingRepo.save(booking);

    }

    public Booking getBookingById(Long bookingId) {
        return bookingRepo.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + bookingId));
    }




}

