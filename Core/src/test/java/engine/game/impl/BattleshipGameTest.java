package engine.game.impl;

import model.client.Client;
import model.coordinate.Coordinate;
import model.ship.Ship;
import model.ship.impl.Battleship;
import org.apache.commons.collections4.SetUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static model.coordinate.Sign.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BattleshipGameTest {

    private BattleshipGame battleshipGame;

    @BeforeMethod
    public void init() {
        battleshipGame = new BattleshipGame();
    }

    @AfterMethod
    public void clean() {
        battleshipGame = null;
    }

    @Test
    public void testCreateNewGame() {
        // given
        UUID gameID = UUID.randomUUID();
        Client client = new Client(UUID.randomUUID());

        // when - then
        assertTrue(battleshipGame.createGame(gameID, client));
    }

    @Test
    public void testCreateNewGameTwoTimes() {
        // given
        UUID gameID = UUID.randomUUID();
        Client client = new Client(UUID.randomUUID());

        // when
        battleshipGame.createGame(gameID, client);

        // then
        assertFalse(battleshipGame.createGame(gameID, client));
    }

    @Test
    public void testFindAvailableGames() {
        // given
        UUID gameID = UUID.randomUUID();
        Client client = new Client(UUID.randomUUID());
        Set<UUID> expectedGamesIDs = new HashSet<>(Arrays.asList(gameID));

        // when
        battleshipGame.createGame(gameID, client);

        // then
        assertTrue(SetUtils.isEqualSet(battleshipGame.findAvailableGames(), expectedGamesIDs));
    }

    @DataProvider
    private static final Object[][] getShips() {
        return new Object[][]{
                {Arrays.asList(
                        new Battleship(Arrays.asList(new Coordinate(A, 1))),
                        new Battleship(Arrays.asList(new Coordinate(C, 1), new Coordinate(C, 2), new Coordinate(C, 3)))
                )},
                {Arrays.asList(
                        new Battleship(Arrays.asList(new Coordinate(B, 5), new Coordinate(C, 5))),
                        new Battleship(Arrays.asList(new Coordinate(I, 7), new Coordinate(I, 8)))
                )},
        };
    }

    @Test(dataProvider = "getShips")
    public void testFindAvailableGameWithOneClient(List<Ship> ships) {
        // given
        UUID gameID = UUID.randomUUID();
        Client gameOwner = new Client(UUID.randomUUID());

        // when
        battleshipGame.createGame(gameID, gameOwner);
        battleshipGame.initClientShips(gameID, gameOwner, ships);

        // then
        assertTrue(battleshipGame.findAvailableGames().contains(gameID));
    }

    @Test(dataProvider = "getShips")
    public void testFindUnavailableGameWithTwoClients(List<Ship> ships) {
        // given
        UUID gameID = UUID.randomUUID();
        Client gameOwner = new Client(UUID.randomUUID());
        Client newClient = new Client(UUID.randomUUID());

        // when
        battleshipGame.createGame(gameID, gameOwner);
        battleshipGame.initClientShips(gameID, gameOwner, ships);
        battleshipGame.joinGame(gameID, newClient);
        battleshipGame.initClientShips(gameID, newClient, ships);

        // then
        assertFalse(battleshipGame.findAvailableGames().contains(gameID));
    }

    @Test
    public void testJoinGame() {
        // given
        UUID gameID = UUID.randomUUID();
        Client gameOwner = new Client(UUID.randomUUID());
        Client newClient = new Client(UUID.randomUUID());

        // when
        battleshipGame.createGame(gameID, gameOwner);

        // then
        assertTrue(battleshipGame.joinGame(gameID, newClient));
    }

    @Test(dataProvider = "getShips")
    public void testAbandonGame(List<Ship> ships) {
        // given
        UUID gameID = UUID.randomUUID();
        Client gameOwner = new Client(UUID.randomUUID());
        Client newClient = new Client(UUID.randomUUID());

        // when
        battleshipGame.createGame(gameID, gameOwner);
        battleshipGame.initClientShips(gameID, gameOwner, ships);
        battleshipGame.joinGame(gameID, newClient);
        battleshipGame.initClientShips(gameID, newClient, ships);

        // then
        assertTrue(battleshipGame.abandonGame(gameID, newClient));
    }

    @Test
    public void testLeaveGame(){
        // given
        UUID gameID = UUID.randomUUID();
        Client gameOwner = new Client(UUID.randomUUID());
        Client newClient = new Client(UUID.randomUUID());

        // when
        battleshipGame.createGame(gameID, gameOwner);
        battleshipGame.joinGame(gameID, newClient);

        // then
        assertTrue(battleshipGame.leaveGame(gameID, gameOwner));
    }

}
