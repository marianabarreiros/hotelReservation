package controller.client;

import model.client.Client;
import model.client.Regular;
import model.client.Rewards;

public class SimpleClientFactory {
    private Client clientType;

    public Client getClientType() {
        return clientType;
    }

    public boolean creatClient(String client) {
        switch (client.toLowerCase()) {
            case "regular":
                clientType = new Regular();
                return true;
            case "rewards":
                clientType = new Rewards();
                return true;
            default:
                return false;
        }
    }
}
