package at.dalex.guiapi;

import at.dalex.guiapi.event.GUIClickEvent;
import at.dalex.guiapi.event.GUICloseEvent;
import at.dalex.guiapi.view.InventoryGUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TestGUI extends InventoryGUI implements Listener {

    public TestGUI() {
        setInventory(createInventory());
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    @EventHandler
    public void onGUIClose(GUICloseEvent<InventoryGUI> event) {
        event.getGuiHolder().sendMessage("§cGUI closed.");
    }

    @EventHandler
    public void onGuiClick(GUIClickEvent<InventoryGUI> event) {
        event.getGuiHolder().sendMessage("Clicked item: " + event.getClickedItem().getType().toString());
    }

    private Inventory createInventory() {
        Inventory inv = Bukkit.createInventory(null, 27, "§b§lTest");
        ItemStack spacer = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        for (int i = 0; i < 9; i++) inv.setItem(i, spacer);
        for (int i = 0; i < 9; i++) inv.setItem(17 + i, spacer);
        inv.setItem(14, item);
        return inv;
    }
}
