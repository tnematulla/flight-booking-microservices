package com.tcs.flights.service;
import com.tcs.flights.exceptions.FlightNotFoundException;
import com.tcs.flights.exceptions.FlightSearchNotFoundException;
import com.tcs.flights.repo.FlightRepo;
import com.tcs.flights.entity.Flights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;


@Service
public class FlightService {

    @Autowired
    private FlightRepo flightRepo;

    public List<Flights> search(String source, String destination, LocalDate travelDate) {
        List<Flights> flights= flightRepo.findBySourceIgnoreCaseAndDestinationIgnoreCaseAndTravelDate(source, destination, travelDate);
        if (flights.isEmpty()) {
            throw new FlightSearchNotFoundException("No flights found from '" + source + "' to '" + destination + "' on " + travelDate);
        }
        return flights;
    }


    public Flights getFlightById(Long id) {
        return  flightRepo.findById(id).orElseThrow(() -> new FlightNotFoundException("Flight not found with ID: " + id));

    }
}