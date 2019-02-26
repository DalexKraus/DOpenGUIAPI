package at.dalex.guiapi.view;

import at.dalex.guiapi.event.GUIClickEvent;
import at.dalex.guiapi.event.GUICloseEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class InventoryGUI extends GUIBase {

    private Inventory inventory;

    public InventoryGUI() {
        this.inventory = Bukkit.createInventory(null, 9, "§4No Inventory set.");
    }

    @Override
    protected void onGUIOpen(Player viewHolder) {
        viewHolder.openInventory(this.inventory);
    }

    @Override
    protected void onGUIClose(Player viewHolder) {
        Bukkit.getServer().getPluginManager().callEvent(new GUICloseEvent<>(this, viewHolder));
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player viewHolder = (Player) e.getWhoClicked();
        if (GUIManager.isPlayerHoldingGUI(viewHolder.getUniqueId())
                && GUIManager.getOpenedGUIFromPlayer(viewHolder.getUniqueId()).equals(getGuiId())
                && e.getCurrentItem() != null) {
            e.setCancelled(true);
            Bukkit.getPluginManager().callEvent(new GUIClickEvent<>(this, viewHolder, e.getCurrentItem()));
            viewHolder.sendMessage("Sent");
        }
    }

    protected void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
