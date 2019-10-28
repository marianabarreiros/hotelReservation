package model.pricetable;

public class PriceTable{

    private final String clientType;
    private final double weekdayPrice;
    private final double weekendRate;

    public PriceTable(String clientType, double weekdayPrice, double weekendRate) {
        this.clientType = clientType;
        this.weekdayPrice = weekdayPrice;
        this.weekendRate = weekendRate;
    }

    public String getClientType() { return clientType; }

    public double getWeekdayPrice() { return weekdayPrice; }

    public double getWeekendRate() { return weekendRate; }

    @Override
    public String toString() {
        return "PriceTable{" +
                "clientType='" + clientType + '\'' +
                ", weekdayPrice=" + weekdayPrice +
                ", weekendRate=" + weekendRate +
                '}';
    }
}
