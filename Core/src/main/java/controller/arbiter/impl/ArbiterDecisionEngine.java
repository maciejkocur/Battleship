package controller.arbiter.impl;

import model.coordinate.Coordinate;
import model.player.Player;
import model.ship.Ship;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArbiterDecisionEngine {

    private Map<Player, List<Coordinate>> playerCoordinates = new HashMap<>();

    public void addCoordinatesFromShip(Player player, Ship ship) {
        if (CollectionUtils.isEmpty(playerCoordinates.get(player)))
            playerCoordinates.put(player, new ArrayList<>());
        playerCoordinates.get(player).addAll(ship.getCoordinates());
    }

    public boolean contains(Player player, Coordinate coordinate) {
        return playerCoordinates.get(player).contains(coordinate);
    }

    public boolean checkWinningConditionForPlayer(Player player) {
        return CollectionUtils.isEmpty(playerCoordinates.get(player));
    }

    public boolean isHit(Player player, Coordinate coordinate) {
        return playerCoordinates.get(player).remove(coordinate);
    }
}
