package engine.cache.util;

import model.client.Client;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class GameCacheValidatorTest {

    Map<UUID, Set<Client>> gameCache;

    @BeforeMethod
    public void shipInit() {
        gameCache = new HashMap<>();
    }

    @AfterMethod
    public void cleaning() {
        gameCache = null;
    }


    @Test
    public void testValidateAndAddWithZeroClients() {
        // given
        Client firstClient = new Client(UUID.randomUUID());
        UUID gameID = UUID.randomUUID();

        // when - then
        assertTrue(GameCacheValidator.validateAndRegisterGameID(gameCache, gameID, firstClient));
    }

    @Test
    public void testValidateAndAddExistingGameID() {
        // given
        Client firstClient = new Client(UUID.randomUUID());
        UUID gameID = UUID.randomUUID();

        // when
        GameCacheValidator.validateAndRegisterGameID(gameCache, gameID, firstClient);

        // then
        assertFalse(GameCacheValidator.validateAndRegisterGameID(gameCache, gameID, firstClient));
    }

    @Test
    public void testValidateAndUpdateExistingGameWithOneClient() {
        // given
        Client firstClient = new Client(UUID.randomUUID());
        Client secondClient = new Client(UUID.randomUUID());
        UUID gameID = UUID.randomUUID();

        // when
        GameCacheValidator.validateAndRegisterGameID(gameCache, gameID, firstClient);

        // then
        assertTrue(GameCacheValidator.validateAndAddNewClientToGameID(gameCache, gameID, secondClient));
    }

    @Test
    public void testValidateAndUpdateExistingGameWithTwoClients() {
        // given
        Client firstClient = new Client(UUID.randomUUID());
        Client secondClient = new Client(UUID.randomUUID());
        Client thirdClient = new Client(UUID.randomUUID());
        UUID gameID = UUID.randomUUID();

        // when
        GameCacheValidator.validateAndRegisterGameID(gameCache, gameID, firstClient);
        GameCacheValidator.validateAndAddNewClientToGameID(gameCache, gameID, secondClient);

        // then
        assertFalse(GameCacheValidator.validateAndAddNewClientToGameID(gameCache, gameID, thirdClient));
    }

    @Test
    public void testValidateAndUpdateNonExistingGame() {
        // given
        Client firstClient = new Client(UUID.randomUUID());
        UUID gameID = UUID.randomUUID();

        // when - then
        assertFalse(GameCacheValidator.validateAndAddNewClientToGameID(gameCache, gameID, firstClient));
    }
}
