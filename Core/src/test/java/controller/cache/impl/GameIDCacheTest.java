package controller.cache.impl;

import model.client.Client;
import org.apache.commons.collections4.SetUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.testng.Assert.*;

/**
 * Created by lucz on 02.08.16.
 */
public class GameIDCacheTest {

    private BattleshipGameCache gameIDCache;

    @BeforeMethod
    public void init() {
        gameIDCache = new BattleshipGameCache();
    }

    @AfterMethod
    public void clean() {
        gameIDCache = null;
    }

    @Test
    public void testAddToCacheOneClient() {
        // given
        UUID gameID = UUID.randomUUID();
        Client firstClient = new Client(UUID.randomUUID());

        // when - then
        assertTrue(gameIDCache.registerGameIDAndClient(gameID, firstClient));
    }

    @Test
    public void testAddToCacheTwoClients() {
        // given
        UUID gameID = UUID.randomUUID();
        Client firstClient = new Client(UUID.randomUUID());
        Client secondClient = new Client(UUID.randomUUID());

        // when - then
        assertTrue(gameIDCache.registerGameIDAndClient(gameID, firstClient));
        assertTrue(gameIDCache.updateExistingGameID(gameID, secondClient));
    }


    @Test
    public void testAddToCacheThreeClients() {
        // given
        UUID gameID = UUID.randomUUID();
        Client firstClient = new Client(UUID.randomUUID());
        Client secondClient = new Client(UUID.randomUUID());
        Client thirdClient = new Client(UUID.randomUUID());

        // when - then
        assertTrue(gameIDCache.registerGameIDAndClient(gameID, firstClient));
        assertTrue(gameIDCache.updateExistingGameID(gameID, secondClient));
        assertFalse(gameIDCache.updateExistingGameID(gameID, thirdClient));
    }

    @Test
    public void testAddToCacheTwoClientsAndGet() {
        UUID gameID = UUID.randomUUID();
        Client firstClient = new Client(UUID.randomUUID());
        Client secondClient = new Client(UUID.randomUUID());

        // when
        gameIDCache.registerGameIDAndClient(gameID, firstClient);
        gameIDCache.updateExistingGameID(gameID, secondClient);

        // then
        assertTrue(SetUtils.isEqualSet(gameIDCache.getCachedClients(gameID), new HashSet<>(Arrays.asList(firstClient, secondClient))));
    }

    @Test
    public void testGetClientsForNonExistingGameID() {
        // given
        UUID gameID = UUID.randomUUID();

        // when - then
        assertNull(gameIDCache.getCachedClients(gameID));
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
        gameIDCache.registerGameIDAndClient(firstGameID, new Client(firstGameID));
        gameIDCache.registerGameIDAndClient(secondGameID, new Client(secondGameID));
        gameIDCache.registerGameIDAndClient(thirdGameID, new Client(thirdGameID));
        gameIDCache.registerGameIDAndClient(fourthGameID, new Client(fourthGameID));

        // then
        assertTrue(SetUtils.isEqualSet(gameIDCache.getAvailableGames(), expectedGamesIDs));
    }

}
