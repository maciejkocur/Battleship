package engine.cache.impl;

import engine.cache.GameCache;
import model.client.Client;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.SetUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class BattleshipGameCacheTest {

    private GameCache battleshipGameCache;

    @BeforeMethod
    public void init() {
        battleshipGameCache = BattleshipGameCache.create();
    }

    @AfterMethod
    public void clean() {
        battleshipGameCache = null;
    }

    @Test
    public void testAddToCacheOneClient() {
        // given
        UUID gameID = UUID.randomUUID();
        Client firstClient = new Client(UUID.randomUUID());

        // when - then
        assertTrue(battleshipGameCache.registerGameIDAndClient(gameID, firstClient));
    }

    @Test
    public void testAddToCacheTwoClients() {
        // given
        UUID gameID = UUID.randomUUID();
        Client firstClient = new Client(UUID.randomUUID());
        Client secondClient = new Client(UUID.randomUUID());

        // when - then
        assertTrue(battleshipGameCache.registerGameIDAndClient(gameID, firstClient));
        assertTrue(battleshipGameCache.updateExistingGameIDAndAddClient(gameID, secondClient));
    }


    @Test
    public void testAddToCacheThreeClients() {
        // given
        UUID gameID = UUID.randomUUID();
        Client firstClient = new Client(UUID.randomUUID());
        Client secondClient = new Client(UUID.randomUUID());
        Client thirdClient = new Client(UUID.randomUUID());

        // when - then
        assertTrue(battleshipGameCache.registerGameIDAndClient(gameID, firstClient));
        assertTrue(battleshipGameCache.updateExistingGameIDAndAddClient(gameID, secondClient));
        assertFalse(battleshipGameCache.updateExistingGameIDAndAddClient(gameID, thirdClient));
    }

    @Test
    public void testAddToCacheTwoClientsAndGet() {
        UUID gameID = UUID.randomUUID();
        Client firstClient = new Client(UUID.randomUUID());
        Client secondClient = new Client(UUID.randomUUID());

        // when
        battleshipGameCache.registerGameIDAndClient(gameID, firstClient);
        battleshipGameCache.updateExistingGameIDAndAddClient(gameID, secondClient);

        // then
        assertTrue(SetUtils.isEqualSet(battleshipGameCache.getCachedClients(gameID), new HashSet<>(Arrays.asList(firstClient, secondClient))));
    }

    @Test
    public void testGetClientsForNonExistingGameID() {
        // given
        UUID gameID = UUID.randomUUID();

        // when - then
        assertNull(battleshipGameCache.getCachedClients(gameID));
    }

    @Test
    public void testGetAvailableGames() {
        // given
        UUID firstGameID = UUID.randomUUID();
        UUID secondGameID = UUID.randomUUID();
        UUID thirdGameID = UUID.randomUUID();
        UUID fourthGameID = UUID.randomUUID();
        Set<UUID> expectedGamesIDs = new HashSet<>(Arrays.asList(firstGameID, secondGameID, thirdGameID, fourthGameID));

        // when
        battleshipGameCache.registerGameIDAndClient(firstGameID, new Client(firstGameID));
        battleshipGameCache.registerGameIDAndClient(secondGameID, new Client(secondGameID));
        battleshipGameCache.registerGameIDAndClient(thirdGameID, new Client(thirdGameID));
        battleshipGameCache.registerGameIDAndClient(fourthGameID, new Client(fourthGameID));

        // then
        assertTrue(SetUtils.isEqualSet(battleshipGameCache.getAvailableGames(), expectedGamesIDs));
    }

    @Test
    public void testUpdateExistingClientStatusToReady() {
        UUID gameID = UUID.randomUUID();
        Client client = new Client(UUID.randomUUID());

        // when
        battleshipGameCache.registerGameIDAndClient(gameID, client);
        battleshipGameCache.updateClientsStatusToReadyForGameID(gameID, client);
        Boolean status = battleshipGameCache.getCachedClients(gameID).stream().filter(c -> c.equals(client)).findFirst().get().isReady();

        // then
        assertTrue(status);
    }

    @Test
    public void testUpdateNonExistingClientStatus() {
        UUID gameID = UUID.randomUUID();
        Client client = new Client(UUID.randomUUID());

        // when
        battleshipGameCache.registerGameIDAndClient(gameID, client);
        battleshipGameCache.removeClientFromGame(gameID, client);
        battleshipGameCache.updateClientsStatusToReadyForGameID(gameID, client);
        battleshipGameCache.updateClientsStatusToNotReadyForGameID(gameID, client);

        // then
        assertTrue(CollectionUtils.isEmpty(battleshipGameCache.getCachedClients(gameID).stream().filter(c -> c.equals(client)).collect(Collectors.toList())));
    }

    @Test
    public void testUpdateClientStatusToNotReady() {
        UUID gameID = UUID.randomUUID();
        Client client = new Client(UUID.randomUUID());

        // when
        battleshipGameCache.registerGameIDAndClient(gameID, client);
        battleshipGameCache.updateClientsStatusToNotReadyForGameID(gameID, client);
        Boolean status = battleshipGameCache.getCachedClients(gameID).stream().filter(c -> c.equals(client)).findFirst().get().isReady();

        // then
        assertFalse(status);
    }

    @Test
    public void testRemoveExistingClientFromGame() {
        UUID gameID = UUID.randomUUID();
        Client firstClient = new Client(UUID.randomUUID());
        Client secondClient = new Client(UUID.randomUUID());

        // when
        battleshipGameCache.registerGameIDAndClient(gameID, firstClient);
        battleshipGameCache.updateExistingGameIDAndAddClient(gameID, secondClient);
        battleshipGameCache.removeClientFromGame(gameID, secondClient);

        // then
        assertFalse(battleshipGameCache.getCachedClients(gameID).contains(secondClient));
    }

    @Test
    public void testRemoveNonExistingClientFromGame() {
        UUID gameID = UUID.randomUUID();
        Client firstClient = new Client(UUID.randomUUID());


        // when
        battleshipGameCache.registerGameIDAndClient(gameID, firstClient);
        battleshipGameCache.removeClientFromGame(gameID, firstClient);

        // then
        assertFalse(battleshipGameCache.removeClientFromGame(gameID, firstClient));
        assertFalse(battleshipGameCache.getCachedClients(gameID).contains(firstClient));
    }

    @Test
    public void testRemoveNonExistingClientFromNonExistingGame() {
        UUID gameID = UUID.randomUUID();
        Client firstClient = new Client(UUID.randomUUID());

        // when - then
        assertFalse(battleshipGameCache.removeClientFromGame(gameID, firstClient));
    }

    @Test
    public void testRemoveGameIDAndData() {
        // given
        UUID firstGameID = UUID.randomUUID();
        UUID secondGameID = UUID.randomUUID();
        UUID thirdGameID = UUID.randomUUID();
        UUID fourthGameID = UUID.randomUUID();
        Set<UUID> expectedGamesIDs = new HashSet<>(Arrays.asList(firstGameID, thirdGameID));

        // when
        battleshipGameCache.registerGameIDAndClient(firstGameID, new Client(firstGameID));
        battleshipGameCache.registerGameIDAndClient(secondGameID, new Client(secondGameID));
        battleshipGameCache.registerGameIDAndClient(thirdGameID, new Client(thirdGameID));
        battleshipGameCache.registerGameIDAndClient(fourthGameID, new Client(fourthGameID));
        battleshipGameCache.removeGameIDAndData(secondGameID);
        battleshipGameCache.removeGameIDAndData(fourthGameID);

        // then
        assertTrue(SetUtils.isEqualSet(battleshipGameCache.getAvailableGames(), expectedGamesIDs));
    }

    @Test
    public void testCleaningUnusedGameIDs() {
        // given
        UUID firstGameID = UUID.randomUUID();
        UUID secondGameID = UUID.randomUUID();
        UUID thirdGameID = UUID.randomUUID();
        UUID fourthGameID = UUID.randomUUID();
        Set<UUID> expectedGamesIDs = new HashSet<>(Arrays.asList(thirdGameID, fourthGameID));

        // when
        battleshipGameCache.registerGameIDAndClient(firstGameID, new Client(firstGameID));
        battleshipGameCache.registerGameIDAndClient(secondGameID, new Client(secondGameID));
        battleshipGameCache.registerGameIDAndClient(thirdGameID, new Client(thirdGameID));
        battleshipGameCache.registerGameIDAndClient(fourthGameID, new Client(fourthGameID));
        battleshipGameCache.removeClientFromGame(firstGameID, new Client(firstGameID));
        battleshipGameCache.removeClientFromGame(secondGameID, new Client(secondGameID));

        // then
        assertTrue(SetUtils.isEqualSet(battleshipGameCache.getAvailableGames(), expectedGamesIDs));

    }
}
