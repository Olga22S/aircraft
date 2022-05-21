package ru.ospyshkina;

import java.time.LocalDateTime;

public class FlightAfterCurrentDateTimeFilter implements FlightFilter {

    private final LocalDateTime currentDateTime;

    public FlightAfterCurrentDateTimeFilter(LocalDateTime currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    @Override
    public boolean test(Flight flight) {
        return currentDateTime.isBefore(flight.getSegments().get(0).getDepartureDate());
    }
}
