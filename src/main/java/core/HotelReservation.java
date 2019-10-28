package core;

import controller.file.FileReading;
import controller.file.ValidateFileLines;
import controller.hotel.FindCheapestHotel;
import model.hotel.Hotel;
import model.pricetable.PriceTable;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class HotelReservation {

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main (String[] args) {
        List<Hotel> listaHoteis = loadHotels();
        FileReading fileReading = new FileReading();
        ValidateFileLines validateFileLines = new ValidateFileLines(fileReading.readFile());

        for (String fileLine : validateFileLines.validateFileLinesAcrossByPattern()) {
            FindCheapestHotel findCheapestHotel = new FindCheapestHotel(fileLine, listaHoteis);
            LOGGER.log(Level.INFO, "The hotel more cheap  is:");
            try {
                System.out.println(findCheapestHotel.findCheapestHotel());
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Maybe some client not exist. Verify your entry file!!");
                throw new NullPointerException();
            }
        }
    }

    private static List<Hotel> loadHotels() {

        LOGGER.log(Level.INFO, "Creating the Hotels.");
        Hotel lakewood = new Hotel("Lakewood", '3');
        Hotel bridgewood = new Hotel("Bridgewood", '4');
        Hotel ridgewood = new Hotel("Ridgewood", '5');

        LOGGER.log(Level.INFO, "Creating the Price Tables.");
        PriceTable lakewoodRegular = new PriceTable("Regular", 110, 90);
        PriceTable lakewoodRewards = new PriceTable("Rewards", 80, 80);
        PriceTable bridgewoodRegular = new PriceTable("Regular", 160, 60);
        PriceTable bridgewoodRewards = new PriceTable("Rewards", 110, 50);
        PriceTable ridgewoodRegular = new PriceTable("Regular", 220, 150);
        PriceTable ridgewoodRewards = new PriceTable("Rewards", 100, 40);

        LOGGER.log(Level.INFO, "Add price dinamically in the Hotels.");
        lakewood.addPriceDinamically(lakewoodRegular);
        lakewood.addPriceDinamically(lakewoodRewards);
        bridgewood.addPriceDinamically(bridgewoodRegular);
        bridgewood.addPriceDinamically(bridgewoodRewards);
        ridgewood.addPriceDinamically(ridgewoodRegular);
        ridgewood.addPriceDinamically(ridgewoodRewards);

        return Arrays.asList(lakewood, bridgewood, ridgewood);
    }
}
