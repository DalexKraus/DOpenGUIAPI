package at.dalex.guiapi;

import at.dalex.guiapi.view.GUIManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    private static Main instance;
    private TestGUI gui;

    @Override
    public void onEnable() {
        instance = this;
        gui = new TestGUI();
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        //Close any still open GUIs, so players can't steal from them
        GUIManager.closeAllGUIs();
    }

    public static Main getInstance() {
        return instance;
    }

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e) {
        if (e.getPlayer().isSneaking()) {
            gui.openGUI(e.getPlayer());
        }
    }
}
