package ru.ospyshkina;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Objects.isNull;

public class FlightsFilterImpl implements FlightsFilter {
    @Override
    public List<Flight> excludeFlightsBeforeCurrentTime(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>(flights);
        filteredFlights.removeIf(flight ->
                LocalDateTime.now().isAfter(flight.getSegments().get(0).getDepartureDate()));
        return filteredFlights;
    }


    @Override
    public List<Flight> excludeFlightsArrivalBeforeDeparture(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>(flights);
        Iterator<Flight> iterator = filteredFlights.iterator();
        while (iterator.hasNext()) {
            Flight flight = iterator.next();
            if (isArrivalBeforeDeparture(flight.getSegments())) {
                iterator.remove();
            }
        }
        return filteredFlights;
    }

    @Override
    public List<Flight> excludeFlightsWithGroundTimeMoreTwoHours(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>(flights);
        Iterator<Flight> iterator = filteredFlights.iterator();
        while (iterator.hasNext()) {
            Flight flight = iterator.next();
            if (isMoreTwoHoursGroundTime(flight.getSegments())) {
                iterator.remove();
            }
        }
        return filteredFlights;
    }

    private boolean isMoreTwoHoursGroundTime(List<Segment> segments) {
        Duration groundTime = null;
        for (int i = 0; i < segments.size() - 1; i++) {
            Duration duration =
                    Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate());
            if (isNull(groundTime)) {
                groundTime = duration;
            } else {
                groundTime = duration.plus(groundTime);
            }
            if (groundTime.toHours() > 2) {
                return true;
            }
        }
        return false;
    }

    private boolean isArrivalBeforeDeparture(List<Segment> segments) {
        for (Segment segment : segments) {
            if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                return true;
            }
        }
        return false;
    }
}
