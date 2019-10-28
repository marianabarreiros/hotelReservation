package controller.hotel;

import model.hotel.Hotel;
import model.pricetable.PriceTable;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FindCheapestHotelTest {

    private List<Hotel> listaHoteis;
    private String fileLine;
    private FindCheapestHotel findCheapestHotel;

    @Before
    public void setUp() {

        Hotel lakewood = new Hotel("Lakewood", '3');
        Hotel bridgewood = new Hotel("Bridgewood", '4');
        Hotel ridgewood = new Hotel("Ridgewood", '5');

        PriceTable lakewoodRegular = new PriceTable("Regular", 110, 90);
        PriceTable lakewoodRewards = new PriceTable("Rewards", 80, 80);
        PriceTable bridgewoodRegular = new PriceTable("Regular", 160, 60);
        PriceTable bridgewoodRewards = new PriceTable("Rewards", 110, 50);
        PriceTable ridgewoodRegular = new PriceTable("Regular", 220, 150);
        PriceTable ridgewoodRewards = new PriceTable("Rewards", 100, 40);

        lakewood.addPriceDinamically(lakewoodRegular);
        lakewood.addPriceDinamically(lakewoodRewards);
        bridgewood.addPriceDinamically(bridgewoodRegular);
        bridgewood.addPriceDinamically(bridgewoodRewards);
        ridgewood.addPriceDinamically(ridgewoodRegular);
        ridgewood.addPriceDinamically(ridgewoodRewards);

        listaHoteis = Arrays.asList(lakewood, bridgewood, ridgewood);
    }

    @Test
    public void mightReturnRidgewoodLikeTheHotelMoreCheap(){
        fileLine = "Rewards:26Mar2009(thur),27Mar2009(fri),28Mar2009(sat)";
        findCheapestHotel = new FindCheapestHotel(fileLine, listaHoteis);
        assertEquals("Ridgewood", findCheapestHotel.findCheapestHotel());
    }

    @Test
    public void mightReturnLakewoodLikeTheHotelMoreCheap(){
        fileLine = "Regular: 16Mar2009(mon),17Mar2009(tues),18Mar2009(wed)";
        findCheapestHotel = new FindCheapestHotel(fileLine, listaHoteis);
        assertEquals("Lakewood", findCheapestHotel.findCheapestHotel());
    }

    @Test
    public void mightReturnBridgewoodLikeTheHotelMoreCheap(){
        fileLine = "Regular:20Mar2009(fri),21Mar2009(sat),22Mar2009(sun)";
        findCheapestHotel = new FindCheapestHotel(fileLine, listaHoteis);
        assertEquals("Bridgewood", findCheapestHotel.findCheapestHotel());
    }

    @Test(expected = NullPointerException.class)
    public void test()throws NullPointerException{
        fileLine = "Especial:20Mar2009(fri),21Mar2009(sat),22Mar2009(sun)";
        findCheapestHotel = new FindCheapestHotel(fileLine, listaHoteis);
        findCheapestHotel.findCheapestHotel();
    }
}