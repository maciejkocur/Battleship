package model.client;

import org.testng.annotations.Test;

import java.util.UUID;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by kuba on 18.07.16.
 */
public class ClientTest {

    @Test
    public void testEqualityOfClients() {
        // Given
        UUID clientID = UUID.randomUUID();
        Client firstClient = new Client(clientID);
        Client secondClient = new Client(clientID);
        Client thirdClient = new Client(clientID);

        // when - then
        // reflexive
        assertEquals(firstClient, firstClient);
        // symmetric
        assertEquals(firstClient, firstClient);
        assertEquals(secondClient, thirdClient);
        // transitive
        assertEquals(firstClient, thirdClient);
    }

    @Test
    public void testChangeStatusToReady() {
        // Given
        UUID clientID = UUID.randomUUID();
        Client client = new Client(clientID);

        // when
        client.ready();

        // then
        assertTrue(client.isReady());
    }

    @Test
    public void testChangeStatusToNotReady() {
        // Given
        UUID clientID = UUID.randomUUID();
        Client client = new Client(clientID);

        // when
        client.ready();
        client.notReady();

        // then
        assertFalse(client.isReady());
    }
}