package at.dalex.guiapi;

import at.dalex.guiapi.view.InventoryGUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(this, this);
    }

    public static Main getInstance() {
        return instance;
    }

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e) {
        if (e.getPlayer().isSneaking()) {
            TestGUI gui = new TestGUI();
            gui.openGUI(e.getPlayer());
            e.getPlayer().sendMessage("GUI Opened.");
        }
    }
}
