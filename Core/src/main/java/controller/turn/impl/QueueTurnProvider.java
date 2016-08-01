package controller.turn.impl;

import controller.turn.TurnProvider;
import model.player.Player;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class QueueTurnProvider implements TurnProvider {

    private Queue<Player> turnQueue;

    private QueueTurnProvider(Queue<Player> turnQueue) {
        this.turnQueue = turnQueue;
    }

    public static QueueTurnProvider getTurnProvider(Player player1, Player player2) {
        Queue<Player> turnQueue = new ArrayDeque<>();
        turnQueue.addAll(Arrays.asList(player1, player2));
        return new QueueTurnProvider(turnQueue);
    }

    @Override
    public Player getCurrentPlayer() {
        return turnQueue.peek();
    }

    @Override
    public Player getNextPlayer() {
        Player currentPlayer = turnQueue.poll();
        turnQueue.add(currentPlayer);
        return turnQueue.peek();
    }

}
