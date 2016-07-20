package controller.arbiter;

import model.coordinate.Coordinate;
import model.player.Player;
import model.ship.Ship;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

public class ArbiterDecisionEngine {

    private Map<Player, List<Coordinate>> playerCoordinates = new HashMap<>();

    public void addCoordinatesFromShip(Player player, Ship ship) {
        if (CollectionUtils.isEmpty(playerCoordinates.get(player)))
            playerCoordinates.put(player, new ArrayList<>());
        Optional.ofNullable(playerCoordinates.get(player)).ifPresent(mapCoordinates -> mapCoordinates.addAll(ship.getCoordinates()));
    }

    boolean contains(Player player, Coordinate coordinate) {
        return playerCoordinates.get(player).contains(coordinate);
    }

    public boolean checkWinningConditionForPlayer(Player player) {
        return CollectionUtils.isEmpty(playerCoordinates.get(player));
    }

    public boolean isHit(Player player, Coordinate coordinate) {
        return playerCoordinates.get(player).remove(coordinate);
    }
}
