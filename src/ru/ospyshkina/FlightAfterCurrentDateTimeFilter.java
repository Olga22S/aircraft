package ru.ospyshkina;

import java.time.LocalDateTime;

public class FlightAfterCurrentDateTimeFilter implements FlightFilter {

    @Override
    public boolean test(Flight flight) {
        LocalDateTime departure = flight.getSegments().get(0).getDepartureDate();
        return LocalDateTime.now().isBefore(departure);
    }
}