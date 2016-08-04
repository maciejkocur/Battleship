package model.client;

import java.util.UUID;

public class Client {

    private UUID clientID;
    private boolean isReady;

    public Client(UUID clientID) {
        this.clientID = clientID;
        this.isReady = false;
    }

    public boolean isReady() {
        return isReady;
    }

    public void ready() {
        this.isReady = true;
    }

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

    @Override
    public String toString() {
        return String.valueOf(clientID);
    }

}
