package controller.cache;

import model.client.Client;

import java.util.Set;
import java.util.UUID;

/**
 * Created by lucz on 04.08.16.
 */
public interface GameCache {

    boolean registerGameIDAndClient(UUID gameID, Client client);

    boolean updateExistingGameID(UUID gameID, Client client);

    void updateClientsStatusToReadyForGameID(UUID gameID, Client client);

    void updateClientsStatusToNotReadyForGameID(UUID gameID, Client client);

    Set<Client> getCachedClients(UUID gameID);

    Set<UUID> getAvailableGames();
}
