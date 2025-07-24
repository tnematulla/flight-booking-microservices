package com.tcs.booking.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
     public ResourceNotFoundException(String message){
         super(message);
     }
}
