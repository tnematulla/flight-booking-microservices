package com.tcs.booking.Controller;


import com.tcs.booking.entity.Booking;
import com.tcs.booking.entity.Flights;
import com.tcs.booking.service.BookingService;
import com.tcs.booking.wrapper.TicketDetails;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import java.util.List;



@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@Valid @RequestBody Booking booking)
    {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(bookingService.createBooking(booking));

    }

    @GetMapping("/{id}")
    public ResponseEntity<List<TicketDetails>> ticketDetails(@PathVariable Long id){
        Booking booking =new Booking();

        booking = bookingService.getBookingById(id);
        Flights flights = restTemplate.getForObject(
                "http://FLIGHT-SERVICE/api/flights/" + booking.getFlightId(),
                Flights.class);


        TicketDetails ticketDetails=new TicketDetails();
        ticketDetails.setTicketNumber(booking.getBookingReference());
        ticketDetails.setTravelDate(booking.getTravelDate());
        ticketDetails.setFlightName(flights.getAirlineName());
        ticketDetails.setTravelClass(booking.getTravelClass());
        ticketDetails.setAmount(booking.getAmount());
        ticketDetails.setFlightNumber(flights.getFlightNumber());
        ticketDetails.setPassengerName(booking.getFirstName()+ " " + booking.getLastName());
        ticketDetails.setSourceDestination(flights.getSource()+ " -> "+flights.getDestination());
        ticketDetails.setSeatNumber(booking.getSeatNumber());
        ticketDetails.setAge(booking.getAge());
        ticketDetails.setGender(booking.getGender());
        ticketDetails.setBookingTime(booking.getBookingTime());
        ticketDetails.setPaymentStatus(booking.getStatus());
        ticketDetails.setTransactionId(booking.getTransactionId());

//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(Collections.singletonList(ticketDetails));
        return ResponseEntity.ok(Collections.singletonList(ticketDetails));



    }



}

