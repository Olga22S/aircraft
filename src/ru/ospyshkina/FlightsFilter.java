package ru.ospyshkina;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightsFilter {

    List<Flight> excludeFlightsBeforeCurrentTime(List<Flight> flights);

    List<Flight> excludeFlightsArrivalBeforeDeparture(List<Flight> flights);

    List<Flight> excludeFlightsWithGroundTimeMoreTwoHours(List<Flight> flights);
}
