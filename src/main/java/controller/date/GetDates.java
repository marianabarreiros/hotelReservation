package controller.date;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class GetDates {
    private final ValidDates validDates = ValidDates.getInstance();

    public Collection<LocalDate> returnDates(String fileLine) {
        return validDates.returnsListOfValidatedDates(convertingStringToList(fileLine));
    }

    private List<String> convertingStringToList(String fileLine) {
        int endIndex = fileLine.indexOf(":");
        return Arrays.asList(fileLine.substring(endIndex + 1).split(","));
    }
}
