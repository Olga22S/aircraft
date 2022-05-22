package ru.ospyshkina;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.isNull;

public class GroundTimeMoreTwoHoursFilter implements FlightFilter {

    @Override
    public boolean test(Flight flight) {
        List<Segment> segments = flight.getSegments();
        Duration groundTime = null;
        for (int i = 0; i < segments.size() - 1; i++) {
            LocalDateTime arrival = segments.get(i).getArrivalDate();
            LocalDateTime departure = segments.get(i + 1).getDepartureDate();
            Duration duration = Duration.between(arrival, departure);
            if (isNull(groundTime)) {
                groundTime = duration;
            } else {
                groundTime = duration.plus(groundTime);
            }
            if (groundTime.toHours() > 2) {
                return false;
            }
        }
        return true;
    }
}
