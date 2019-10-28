package controller.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
//import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static javax.sql.rowset.spi.SyncFactory.getLogger;

public class ValidDates {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMuuuu");
    private Set<LocalDate> validatedDates;
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final AtomicBoolean isValid = new AtomicBoolean(Boolean.TRUE);

    public ValidDates() {
    }

    public synchronized Set<LocalDate> returnsListOfValidatedDates(List<String> dates) {
        validatedDates = new LinkedHashSet<>();
        Set<String> dates1 = getDatesWithoutDaysOfWeek(dates);
        dates1.forEach(date -> {
            try {
                LocalDate localDate = LocalDate.parse(date, formatter);
                validatedDates.add(localDate);
            } catch (DateTimeParseException e) {
                LOGGER.log(Level.SEVERE, "erro", e.getParsedString());
            }
        });
        return isValid.get() ? validatedDates : null;
    }

    private Set<String> getDatesWithoutDaysOfWeek(List<String> dates) {
        return dates.stream()
                .map(date -> date.substring(0, 9).toLowerCase())
                .collect(Collectors.toSet());
    }
}
