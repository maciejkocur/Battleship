package controller.turn.impl;

import controller.turn.TurnProvider;
import model.client.Client;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class QueueTurnProvider implements TurnProvider {

    private Deque<Client> turnQueue;

    private QueueTurnProvider(Deque<Client> turnQueue) {
        this.turnQueue = turnQueue;
    }

    public static QueueTurnProvider of(Client... clients) {
        Deque<Client> turnQueue = new ArrayDeque<>();
        turnQueue.addAll(Arrays.asList(clients));
        return new QueueTurnProvider(turnQueue);
    }

    @Override
    public Client getCurrentPlayer() {
        return turnQueue.peekFirst();
    }

    @Override
    public Client getNextPlayer() {
        return turnQueue.peekLast();
    }

    @Override
    public void changeTurn(){
        Client currentPlayer = turnQueue.poll();
        turnQueue.add(currentPlayer);
    }

}
