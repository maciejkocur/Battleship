package engine.turn.impl;

import engine.turn.TurnProvider;
import model.client.Client;

import java.util.*;

/**
 * Implementation of {@link TurnProvider} based on queue
 *
 * @author Ogre
 */
public class QueueTurnProvider implements TurnProvider {

    private Deque<Client> turnQueue;

    private QueueTurnProvider(Deque<Client> turnQueue) {
        this.turnQueue = turnQueue;
    }

    /**
     * Factory method to create object with one or more {@link Client}s
     *
     * @param clients one or more clients
     * @return new {@link QueueTurnProvider} object
     */
    public static QueueTurnProvider of(Client... clients) {
        Deque<Client> turnQueue = new ArrayDeque<>();
        Arrays.asList(Optional.ofNullable(clients).orElse(new Client[0])).stream().filter(client -> Objects.nonNull(client)).forEach(turnQueue::add);
        return new QueueTurnProvider(turnQueue);
    }

    /**
     * @see TurnProvider
     */
    @Override
    public Client getCurrentClient() {
        return turnQueue.peekFirst();
    }

    /**
     * @see TurnProvider
     */
    @Override
    public Client getNextClient() {
        return turnQueue.peekLast();
    }

    /**
     * @see TurnProvider
     */
    @Override
    public void changeTurn() {
        Client currentPlayer = turnQueue.poll();
        turnQueue.add(currentPlayer);
    }

}
