package com.tcs.flights.controller;

import com.tcs.flights.entity.Flights;
import com.tcs.flights.service.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    public ResponseEntity<List<Flights>> searchFlights(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate travelDate) {

        log.info("Searching flights from '{}' to '{}' on {}", source, destination, travelDate);

        List<Flights> flights = flightService.search(source, destination, travelDate);

        if (flights.isEmpty()) {
            log.warn("No flights found from '{}' to '{}' on {}", source, destination, travelDate);
            return ResponseEntity.noContent().build(); // 204 No Content
        }

        return ResponseEntity.ok(flights); // 200 OK
    }


    @GetMapping("/{id}")
    public ResponseEntity<Flights> getFlight(@PathVariable Long id) {
         log.info("Fetching flight with ID: {}", id);

        return ResponseEntity.ok(flightService.getFlightById(id));
    }

}
