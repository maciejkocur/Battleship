package components;

import model.client.Client;

import java.util.UUID;

/**
 * Created by bartlomiej on 05.08.16.
 */
public class ClientFactory {

    private static Client client = new Client(UUID.randomUUID());

    public static Client getClient() {
        return client;
    }


}
