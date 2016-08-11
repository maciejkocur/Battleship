package model.client;

import org.testng.annotations.Test;

import java.util.UUID;

import static org.testng.Assert.*;

/**
 * Created by kuba on 18.07.16.
 */
public class ClientTest {

    @Test
    public void testEqualityOfClients() {
        // given
        UUID clientID = UUID.randomUUID();
        Client firstClient = new Client(clientID);
        Client secondClient = new Client(clientID);
        Client thirdClient = new Client(clientID);

        // when - then
        // reflexive
        assertEquals(firstClient, firstClient);
        // symmetric
        assertEquals(firstClient, secondClient);
        assertEquals(secondClient, firstClient);
        // transitive
        assertEquals(firstClient, thirdClient);
    }

    @Test
    public void testInequalityOfDifferentClients() {
        // given
        Client firstClient = new Client(UUID.randomUUID());
        Client secondClient = new Client(UUID.randomUUID());

        // when - then
        assertNotEquals(firstClient, secondClient);
    }

    @Test
    public void testInequalityOfClientAndNull() {
        // given
        Client firstClient = new Client(UUID.randomUUID());
        Client secondClient = null;

        // when - then
        assertNotEquals(firstClient, secondClient);
    }

    @Test
    public void testInequalityOfClientAndObject() {
        // given
        Client firstClient = new Client(UUID.randomUUID());
        Object object = new Object();

        // when - then
        assertNotEquals(firstClient, object);
    }

    @Test
    public void testEqualityOfHashCodesOfClients() {
        // given
        UUID clientID = UUID.randomUUID();
        Client firstClient = new Client(clientID);
        Client secondClient = new Client(clientID);
        Client thirdClient = new Client(clientID);

        // when - then
        assertEquals(firstClient.hashCode(), firstClient.hashCode());
        assertEquals(firstClient.hashCode(), secondClient.hashCode());
        assertEquals(secondClient.hashCode(), thirdClient.hashCode());
        assertEquals(firstClient.hashCode(), thirdClient.hashCode());
    }

    @Test
    public void testChangeStatusToReady() {
        // given
        UUID clientID = UUID.randomUUID();
        Client client = new Client(clientID);

        // when
        client.ready();

        // then
        assertTrue(client.isReady());
    }

    @Test
    public void testChangeStatusToNotReady() {
        // given
        UUID clientID = UUID.randomUUID();
        Client client = new Client(clientID);

        // when
        client.ready();
        client.notReady();

        // then
        assertFalse(client.isReady());
    }

    @Test
    public void testShowClientID(){
        // given
        UUID clientID = UUID.randomUUID();
        Client client = new Client(clientID);

        // when - than
        assertEquals(client.showID(), clientID);
    }
    
}