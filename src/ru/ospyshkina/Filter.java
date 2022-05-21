package ru.ospyshkina;

import java.util.List;

public interface Filter {

    void printFilteredFlights(List<Flight> flights, List<FlightFilter> filters);
}
