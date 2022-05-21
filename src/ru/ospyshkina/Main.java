package ru.ospyshkina;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();
        flights.stream().forEach(System.out::println);
        System.out.println();
        FlightsFilter flightsFilter = new FlightsFilterImpl();
        flightsFilter.excludeFlightsWithGroundTimeMoreTwoHours(flights)
                .stream().forEach(System.out::println);
    }
}
