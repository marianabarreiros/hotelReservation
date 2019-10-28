package model.quotation;

import model.hotel.Hotel;

public class Quotation implements ReturnsRating{

    private final Hotel hotel;
    private final double total;

    public Quotation(Hotel hotel, double total) {
        this.hotel = hotel;
        this.total = total;
    }

    public Hotel getHotel() { return hotel; }

    public double getTotal() { return total; }

    @Override
    public double getHotelRating() { return hotel.getClassification(); }

    @Override
    public String toString() {
        return "Quotation{" +
                "hotel=" + hotel +
                ", total=" + total +
                '}';
    }
}
