package ru.ospyshkina;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();
        Filter filter = new FilterImpl();
        List<FlightFilter> flightFilters = new ArrayList<>();
        flightFilters.add(new FlightAfterCurrentDateTimeFilter(LocalDateTime.now()));
        filter.printFilteredFlights(flights, flightFilters);

//        flights.stream().forEach(System.out::println);
//        System.out.println();
//        FlightsFilter flightsFilter = new FlightsFilterImpl();
//        flightsFilter.excludeFlightsWithGroundTimeMoreTwoHours(flights)
//                .stream().forEach(System.out::println);
    }
}
