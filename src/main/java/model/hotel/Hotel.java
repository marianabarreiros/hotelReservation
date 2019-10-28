package model.hotel;

import model.pricetable.PriceTable;

import java.util.ArrayList;
import java.util.List;

public class Hotel implements DynamicPriceAddition{

    private final String name;
    private final char classification;
    private final List<PriceTable> priceTable;

    public Hotel(String name, char classification) {
        this.name = name;
        this.classification = classification;
        this.priceTable = new ArrayList<>();
    }

    public String getName() { return name; }

    public char getClassification() { return classification; }

    public List<PriceTable> getPriceTable() { return priceTable; }

    @Override
    public void addPriceDinamically(PriceTable priceTable) {
        if (!thereIsClient(priceTable)) {
            this.priceTable.add(priceTable);
        } else {
            System.out.println("Esse Cliente já foi adicionado ao hotel");
        }
    }

    private boolean thereIsClient(PriceTable priceTable) {
        return this.priceTable.stream()
                .filter(p -> p.getClientType().equalsIgnoreCase(priceTable.getClientType()))
                .findAny()
                .isPresent();
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", classification=" + classification +
                ", priceTable=" + priceTable +
                '}';
    }
}
