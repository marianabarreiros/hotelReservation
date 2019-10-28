package controller.client;

public class GetClient {

    public String returnClient(String fileLine) {
        SimpleClientFactory simpleClientFactory = new SimpleClientFactory();
        simpleClientFactory.creatClient(getNameClient(fileLine));
        return simpleClientFactory.getClientType().getTypeClient();
    }

    private String getNameClient(String fileLine) {
        int endIndex = fileLine.indexOf(":");
        return fileLine.substring(0, endIndex);
    }
}
