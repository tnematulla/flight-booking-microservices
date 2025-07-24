# flight-booking-microservices
Flight Booking Microservices

A microservices-based system for flight booking built using Spring Boot 3, Spring Cloud, PostgreSQL, and Eureka. This system includes separate services for flight search, booking management, and API Gateway routing.

---

## 📦 Tech Stack

- **Java:** 21
- **Spring Boot:** 3.5.0
- **Spring Cloud:** 2025.0.0
- **Service Discovery:** Eureka (Netflix)
- **API Gateway:** Spring Cloud Gateway
- **Database:** PostgreSQL
- **Validation:** Jakarta Validation API
- **API Documentation:** SpringDoc OpenAPI v2.5.0
- **Lombok:** For boilerplate code reduction
- **Testing:** Spring Boot Starter Test
- **Build Tool:** Maven

---

## 🧱 Microservices

| Service          | Description                                      |
|------------------|--------------------------------------------------|
| ✈️ Flight Service | Manage flights, availability, search filters     |
| 📃 Booking Service| Book flights, manage passengers & payment       |
| 🌐 API Gateway    | Routes all API requests to appropriate services  |
| 🔍 Eureka Server  | Enables service discovery among microservices   |

---

## 🚀 How to Run the Project

### 🧾 Prerequisites
- Java 21+
- Maven 3.8+
- PostgreSQL up and running

### 🔧 Steps

1. Clone the repository:
   ```bash
   git clone git@github.com:tnematulla/flight-booking-microservices.git

## Features
Search flights by source, destination, and date

✅ Book flights with full passenger and payment details

> Generate booking confirmation with ticket info

> REST-based communication between microservices

> Service Discovery using Eureka

> API Gateway to route and secure services

> Swagger/OpenAPI UI for API testing

## 🧭 Folder Structure
flight-booking-microservices/
│
├── booking-service/
├── flight-service/
├── api-gateway/
├── discovery-server/
└── README.md

##  Future Enhancements   
- 🔒 JWT-based Authentication (Spring Security)
- 🐳 Dockerization of each microservice
- 📊 Monitoring with Spring Boot Actuator + Prometheus + Grafana
- 📬 Email Notification service
- 🎨 Angular/React frontend integration
- 🧾 PDF Ticket Generation with QR code (if not done yet)

...

## 👨‍💻 Author
Md Taha Nematulla
GitHub: @tnematulla
