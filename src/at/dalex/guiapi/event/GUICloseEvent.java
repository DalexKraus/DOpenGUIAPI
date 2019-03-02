package at.dalex.guiapi.event;

import at.dalex.guiapi.view.GUIBase;
import at.dalex.guiapi.view.InventoryGUI;
import org.bukkit.entity.Player;

public class GUICloseEvent<T extends GUIBase> extends GUIEventBase {

    public GUICloseEvent(T guiInstance, Player guiHolder) {
        super(guiInstance, guiHolder);
    }

    public InventoryGUI getGuiInstance() {
        return (InventoryGUI) super.getGuiInstance();
    }
}
