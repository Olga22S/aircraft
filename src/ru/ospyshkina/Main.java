package ru.ospyshkina;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();
        FilteredFlightsPrinter printer = new FilteredFlightsPrinter();
        System.out.println("All flights:");
        flights.forEach(System.out::println);
        List<FlightFilter> flightFilters = new ArrayList<>();
        System.out.println("Exclude departures up to the current time:");
        flightFilters.add(new FlightAfterCurrentDateTimeFilter());
        printer.printFilteredFlights(flights, flightFilters);

        System.out.println("Exclude segments with arrival date earlier than departure date:");
        flightFilters.set(0, new SegmentArrivalBeforeDepartureFilter());
        printer.printFilteredFlights(flights, flightFilters);

        System.out.println("Exclude flights with time spent on the ground for more than two hours:");
        flightFilters.set(0, new GroundTimeMoreTwoHoursFilter());
        printer.printFilteredFlights(flights, flightFilters);

    }
}
