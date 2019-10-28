package model.pricetable;

public class PriceTable{

    private String clientType;
    private double weekdayPrice, weekendRate;

    public PriceTable(String clientType, double weekdayPrice, double weekendRate) {
        this.clientType = clientType;
        this.weekdayPrice = weekdayPrice;
        this.weekendRate = weekendRate;
    }

    public String getClientType() { return clientType; }

    public void setClientType(String clientType) { this.clientType = clientType; }

    public double getWeekdayPrice() { return weekdayPrice; }

    public void setWeekdayPrice(double weekdayPrice) { this.weekdayPrice = weekdayPrice; }

    public double getWeekendRate() { return weekendRate; }

    public void setWeekendRate(double weekendRate) { this.weekendRate = weekendRate; }

    @Override
    public String toString() {
        return "PriceTable{" +
                "clientType='" + clientType + '\'' +
                ", weekdayPrice=" + weekdayPrice +
                ", weekendRate=" + weekendRate +
                '}';
    }
}
