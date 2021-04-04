# Free Tier Backend (EC2 Instance)
Microservices for Utopia Airlines Project

## Requirements & Quick Start
##### -Maven
##### -MySQL
`$ mvn spring-boot:run` - run UtopiaFireeTierBackend as a Spring-Boot Application. The application will run by default on port `8080`.

Configure the port by changing the `server.port` value in the `application.properties` file which is located in the resources folder.

The application can be run with a local MySQL database. Configure the `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` in the `application.properties` file according to your needs.
## API
    - AirplaneMS
    - AirportMS
    - AuthenticationMS
    - BookingMS
    - FlightMS
    - PassengerMS
    - RouteMS
    - UserMS
