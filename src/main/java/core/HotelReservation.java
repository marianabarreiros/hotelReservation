package core;

import controller.file.FileReading;
import controller.file.ValidateFileLines;
import controller.hotel.FindCheapestHotel;
import model.hotel.Hotel;
import model.pricetable.PriceTable;

import java.util.Arrays;
import java.util.List;

class HotelReservation {

    public static void main (String[] args){
        List<Hotel> listaHoteis = loadHotels();
        FileReading fileReading = new FileReading();
        ValidateFileLines validateFileLines = new ValidateFileLines(fileReading.readFile());

        for(String fileLine : validateFileLines.validateFileLinesAcrossByPattern()){
            FindCheapestHotel findCheapestHotel = new FindCheapestHotel(fileLine, listaHoteis);
            System.out.println(findCheapestHotel.findCheapestHotel());
        }
    }

    public static List<Hotel> loadHotels() {
//        Create hostels
        Hotel lakewood = new Hotel("Lakewood", '3');
        Hotel bridgewood = new Hotel("Bridgewood", '4');
        Hotel ridgewood = new Hotel("Ridgewood", '5');

//        Crate price tables
        PriceTable lakewoodRegular = new PriceTable("Regular", 110, 90);
        PriceTable lakewoodRewards = new PriceTable("Rewards", 80, 80);
        PriceTable bridgewoodRegular = new PriceTable("Regular", 160, 60);
        PriceTable bridgewoodRewards = new PriceTable("Rewards", 110, 50);
        PriceTable ridgewoodRegular = new PriceTable("Regular", 220, 150);
        PriceTable ridgewoodRewards = new PriceTable("Rewards", 100, 40);

//        Add tables dinamically
        lakewood.addPriceDinamically(lakewoodRegular);
        lakewood.addPriceDinamically(lakewoodRewards);
        bridgewood.addPriceDinamically(bridgewoodRegular);
        bridgewood.addPriceDinamically(bridgewoodRewards);
        ridgewood.addPriceDinamically(ridgewoodRegular);
        ridgewood.addPriceDinamically(ridgewoodRewards);

        List<Hotel> hotelList = Arrays.asList(lakewood, bridgewood, ridgewood);
        return hotelList;
    }
}
