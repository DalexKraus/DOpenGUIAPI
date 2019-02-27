package at.dalex.guiapi;

import at.dalex.guiapi.view.GUIManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        //Close any still open GUIs, so players can't steal from them
        GUIManager.closeAllGUIs();
    }

    public static Main getInstance() {
        return instance;
    }
}
