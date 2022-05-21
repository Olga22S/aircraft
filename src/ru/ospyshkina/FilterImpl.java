package ru.ospyshkina;

import java.util.List;
import java.util.stream.Stream;

public class FilterImpl implements Filter {
    @Override
    public void printFilteredFlights(List<Flight> flights, List<FlightFilter> filters) {
        Stream stream = flights.stream();
        for (FlightFilter filter : filters) {
            stream.filter(filter);
        }
        stream.forEach(System.out::println);
    }
}
