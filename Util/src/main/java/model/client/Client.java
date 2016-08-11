package model.client;

import java.util.UUID;

/**
 * Representation of game client
 *
 * @author Ogre
 */
public class Client {

    private UUID clientID;
    private boolean isReady;

    public Client(UUID clientID) {
        this.clientID = clientID;
        this.isReady = false;
    }

    /**
     * Returns {@link UUID} - clientsID
     *
     * @return id of client
     */
    public UUID showID() {
        return clientID;
    }

    /**
     * Returns clients status
     *
     * @return true if client is ready, false if not
     */
    public boolean isReady() {
        return isReady;
    }

    /**
     * Change status of client to ready
     */
    public void ready() {
        this.isReady = true;
    }

    /**
     * Change status of client to not ready
     */
    public void notReady() {
        this.isReady = false;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Client other = (Client) object;

        return clientID.equals(other.clientID);
    }

    @Override
    public int hashCode() {
        return clientID.hashCode();
    }

}
