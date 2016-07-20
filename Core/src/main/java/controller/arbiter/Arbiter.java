package controller.arbiter;

import model.coordinate.Coordinate;
import model.player.Player;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

public class Arbiter {

    private Map<Player, List<Coordinate>> playerCoordinates = new HashMap<>();

    public void addCoordinates(Player player, List<Coordinate> coordinates) {
        if (CollectionUtils.isEmpty(playerCoordinates.get(player)))
            playerCoordinates.put(player, new ArrayList<>());
        Optional.ofNullable(playerCoordinates.get(player)).ifPresent(mapCoordinates -> mapCoordinates.addAll(coordinates));
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
