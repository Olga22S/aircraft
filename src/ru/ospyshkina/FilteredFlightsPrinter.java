package ru.ospyshkina;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Objects.isNull;

public class FilteredFlightsPrinter {

    public void printFilteredFlights(List<Flight> flights, List<FlightFilter> filters) {
        if (isNull(filters) || filters.size() == 0) {
            throw new IllegalArgumentException("Filters can not be null or empty!");
        }
        Stream<Flight> stream = flights.stream();
        for (FlightFilter filter : filters) {
            stream = stream.filter(filter);
        }
        stream.forEach(System.out::println);
    }
}
