package controller.hotel;

import controller.client.GetClient;
import controller.date.GetDates;
import model.hotel.Hotel;
import model.pricetable.PriceTable;
import model.quotation.Quotation;

import java.time.LocalDate;
import java.util.*;

public class FindCheapestHotel {
    private final String fileLine;
    private final GetClient getClient;
    private final GetDates getDates;
    private final Collection<Hotel> hotelList;
    private final List<Quotation> quotations = new ArrayList<>();

    public FindCheapestHotel(String fileLine, Collection<Hotel> hotelList) {
        this.fileLine = fileLine;
        this.hotelList = hotelList;
        getClient = new GetClient();
        getDates = new GetDates();
    }

    public String findCheapestHotel(){
        getQuotations().sort(Comparator.comparingDouble(Quotation::getTotal).reversed().thenComparing(Quotation::getHotelRating).reversed());
        return quotations.get(0).getHotel().getName();
    }

    private List<Quotation> getQuotations() {
        for (Hotel hotel : hotelList) {
            double total = getFullValueForPeriodRequested(hotel);
            quotations.add(new Quotation(hotel, total));
        }
        return quotations;
    }

    private double getFullValueForPeriodRequested(Hotel hotel) {
        double full = 0;
        PriceTable price = getPriceTableByClient(hotel, getClient.returnClient(fileLine));
        for (LocalDate date : getDates.returnDates(fileLine)) {
            if (date.getDayOfWeek().getValue() == 6 || date.getDayOfWeek().getValue() == 7) {
                full += price.getWeekendRate();
            } else {
                full += price.getWeekdayPrice();
            }
        }
        return full;
    }

    private PriceTable getPriceTableByClient(Hotel hotel, String client) {
        return hotel.getPriceTable().stream()
                .filter(p -> p.getClientType().equalsIgnoreCase(client))
                .findAny()
                .get();
    }
}
