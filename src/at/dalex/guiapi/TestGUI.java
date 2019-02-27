package at.dalex.guiapi;

import at.dalex.guiapi.event.GUIClickEvent;
import at.dalex.guiapi.event.GUICloseEvent;
import at.dalex.guiapi.view.InventoryGUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TestGUI extends InventoryGUI {

    TestGUI() {
        setInventory(createInventory());
    }

    @EventHandler
    public void onGUIClose(GUICloseEvent<InventoryGUI> event) {
        if (isRelatedToInstance(event)) {
            event.getGuiHolder().sendMessage("§cGUI closed.");
        }
    }

    @EventHandler
    public void onGuiClick(GUIClickEvent<InventoryGUI> event) {
        if (isRelatedToInstance(event)) {
            if (event.getClickedItem().getType().equals(Material.NETHER_STAR)) {
                TestGUI2 gui2 = new TestGUI2();
                gui2.openGUI(event.getGuiHolder());
            }
        }
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
