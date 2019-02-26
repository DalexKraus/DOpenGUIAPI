package at.dalex.guiapi.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class GUIManager {

    /* Contains IDs of every single created gui */
    private static ArrayList<UUID> registeredGUIIds = new ArrayList<>();
    /* Contains information about which player is currently "watching" which GUIId */
    private static HashMap<UUID, UUID> openedGUIs   = new HashMap<>();

    protected static UUID getFreeGUIId() {
        UUID id = null;
        boolean found = false;
        while (!found) {
            id = UUID.randomUUID();
            if (!registeredGUIIds.contains(id))
                found = true;
        }
        return id;
    }

    protected static void unregisterId(UUID guiId) {
        registeredGUIIds.remove(guiId);
    }

    protected static void setOpenedGUIForPlayer(UUID playerId, UUID guiId) {
        openedGUIs.put(playerId, guiId);
    }

    protected static void closeGUIForPlayer(UUID playerId) {
        openedGUIs.remove(playerId);
    }

    public static UUID getOpenedGUIFromPlayer(UUID playerId) {
        return openedGUIs.get(playerId);
    }

    public static boolean isPlayerHoldingGUI(UUID playerId) {
        return openedGUIs.containsKey(playerId);
    }
}
