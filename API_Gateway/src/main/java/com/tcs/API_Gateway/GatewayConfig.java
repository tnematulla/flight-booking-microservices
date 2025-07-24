package com.tcs.API_Gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()

                .route("flight-service", r -> r
                        .path("/api/flights/**")
                        .uri("lb://FLIGHT-SERVICE"))


                .route("booking-service", r -> r
                        .path("/bookings/**")
                        .uri("lb://BOOKING-SERVICE"))

                .build();
    }
}