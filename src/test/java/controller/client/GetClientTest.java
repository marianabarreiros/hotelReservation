package controller.client;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetClientTest {

    private GetClient getClient;
    private String fileLine;

    @Before
    public void setUp() {
        getClient = new GetClient();
        fileLine = "Rewards:26Mar2009(thur),27Mar2009(fri),28Mar2009(sat)";
    }

    @Test
    public void migthReturnClientsName(){
        assertEquals("Rewards", getClient.returnClient(fileLine));
    }

    @Test(expected = NullPointerException.class)
    public void whenClientDontExist_thenReturnFalse() throws NullPointerException{
        String fileWrongLine = "Especial:26Mar2009(thur),27Mar2009(fri),28Mar2009(sat)";
        getClient.returnClient(fileWrongLine);
    }

}