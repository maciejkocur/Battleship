package controller.turn;

import model.player.Player;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class TurnProvider {

    private Queue<Player> turnQueue;

    private TurnProvider(Queue<Player> turnQueue) {
        this.turnQueue = turnQueue;
    }

    public static TurnProvider getTurnProvider(Player player1, Player player2) {
        Queue<Player> turnQueue = new ArrayDeque<>();
        turnQueue.addAll(Arrays.asList(player1, player2));
        return new TurnProvider(turnQueue);
    }


    public Player getCurrentPlayer() {
        return turnQueue.peek();
    }

    public Player getNextPlayer() {
        Player currentPlayer = turnQueue.poll();
        turnQueue.add(currentPlayer);
        return turnQueue.peek();
    }

}
