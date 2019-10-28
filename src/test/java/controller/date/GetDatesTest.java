package controller.date;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.Assert.*;

public class GetDatesTest {

    private GetDates getDates;
    private String fileLine;
    private Collection<LocalDate> localDateList;


    @Before
    public void setUp() {
        getDates = new GetDates();
        fileLine = "Rewards:26Mar2009(thur),27Mar2009(fri),28Mar2009(sat)";
    }

    @Test
    public void whenExistFileLine_thenReturnACollectionOfLocalDate(){
        assertFalse(getDates.returnDates(fileLine).getClass().isInstance(localDateList));
    }

    @Test
    public void whenExistOneLineWithThreeDates_thenReturnTheSizeThreeWithSuccess(){
        assertEquals(3, getDates.returnDates(fileLine).size());
    }

}