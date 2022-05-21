package ru.ospyshkina;

public class SegmentArrivalBeforeDepartureFilter implements FlightFilter {

    @Override
    public boolean test(Flight flight) {
        return !flight.getSegments().stream()
                .anyMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate()));
    }
}
