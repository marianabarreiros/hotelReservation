package controller.client;

import controller.date.ValidDates;

import java.time.LocalDate;
import java.util.*;

class UnmodifiableMapOfClientsEndDates {
    private final SimpleClientFactory simpleClientFactory = new SimpleClientFactory();
    private final Map<String, Set<LocalDate>> mapClientsAndDates = new TreeMap<>();

    public Map<String, Set<LocalDate>> createMap(List<String> listOfFileLines) {
        ValidDates validDates = ValidDates.getInstance();
        String nameClient;
        String[] dates;
        int endIndex;
        for(String fileLine : listOfFileLines){
            endIndex = fileLine.indexOf(":");
            nameClient = fileLine.substring(0, endIndex);
            dates = fileLine.substring(endIndex + 1).split(",");
            List<String> datesAsList = Arrays.asList(dates);
            final boolean createdClient = simpleClientFactory.creatClient(nameClient);
            final Set<LocalDate> validatedDates = validDates.returnsListOfValidatedDates(datesAsList);
            if (createdClient && validatedDates != null) {
                mapClientsAndDates.put(simpleClientFactory.getClientType().getTypeClient(), validatedDates);
            } else {
                System.out.println("Erro ao criar usuário ou a data não é válida " + fileLine);
            }
        }
        return Collections.unmodifiableMap(mapClientsAndDates);
    }
}
