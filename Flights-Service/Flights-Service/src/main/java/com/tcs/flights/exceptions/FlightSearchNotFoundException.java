package com.tcs.flights.exceptions;

public class FlightSearchNotFoundException extends RuntimeException{
    public FlightSearchNotFoundException(String message){
        super(message);
    }
}
