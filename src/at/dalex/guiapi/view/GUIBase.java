package at.dalex.guiapi.view;

import at.dalex.guiapi.Main;
import at.dalex.guiapi.event.GUICloseEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.UUID;

public abstract class GUIBase implements Listener {

    private UUID guiId;

    protected abstract void onGUIOpen(Player viewHolder);
    protected abstract void onGUIClose(Player viewHolder);

    /**
     * Create a new {@link GUIBase}, which will be used
     * as a frame for later graphical interfaces which will
     * be shown to the player.
     */
    protected GUIBase() {
        //Request a new unique id for this GUI
        this.guiId = GUIManager.getFreeGUIId();
        //Register this instance as a listener to the Bukkit API
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    /**
     * Opens this GUIBase for the given player.
     * The previously set View will be displayed.
     *
     *
     * @param player The player for which this interface should be opened.
     */
    public void openGUI(Player player) {
        GUIManager.setOpenedGUIForPlayer(player.getUniqueId(), this.guiId);
        onGUIOpen(player);
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Player viewHolder = (Player) event.getPlayer();
        if (GUIManager.isPlayerHoldingGUI(viewHolder.getUniqueId())) {
            onGUIClose(viewHolder);
            GUIManager.closeGUIForPlayer(viewHolder.getUniqueId());
        }
    }

    /**
     * @return The unique ID of this GUI.
     */
    public UUID getGuiId() {
        return this.guiId;
    }
}
