package com.tcs.flights.repo;

import com.tcs.flights.entity.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepo extends JpaRepository<Flights,Long>
{
    List<Flights> findBySourceIgnoreCaseAndDestinationIgnoreCaseAndTravelDate(
            String source, String destination, LocalDate travelDate
    );
}
