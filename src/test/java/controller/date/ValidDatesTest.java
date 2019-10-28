package controller.date;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class ValidDatesTest {

    private List<String> fileLine;
    private List<String> fileWrongLine;
    private ValidDates validDates;
    private Set<LocalDate> listOfValidDates;

    @Before
    public void setUp() {

        validDates = new ValidDates();
        listOfValidDates = new LinkedHashSet<>();
        fileLine = new ArrayList<>();
        fileWrongLine = new ArrayList<>();

        fileLine.add("16Mar2009(mon)");
        fileLine.add("17Mar2009(tues)");
        fileLine.add("18Mar2009(wed)");
    }

    @Test
    public void whenReceiveAListOfString_thenReturnAListOfSet(){
        assertTrue(validDates.returnsListOfValidatedDates(fileLine).getClass().isInstance(listOfValidDates));
    }

    @Test
    public void whenReceiveAListWithThreeParameters_thenReturnSizeThree(){
        assertEquals(3, validDates.returnsListOfValidatedDates(fileLine).size());
    }

    @Test
    public void whenReceiveAWrongFormat_thenReturnListSizelessOne(){

        final LocalDate localDate1 = LocalDate.parse("2009-03-18", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        final LocalDate localDate2 = LocalDate.parse("2009-03-17", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        fileWrongLine.add("16mar2009(mon)");
        fileWrongLine.add("17Mar2009(tues)");
        fileWrongLine.add("18Mar2009(wed)");
        Set<LocalDate> localDates = new LinkedHashSet<>();

        localDates.add(localDate1);
        localDates.add(localDate2);

        assertEquals(localDates, validDates.returnsListOfValidatedDates(fileWrongLine));
    }

}