package at.dalex.guiapi.event;

import at.dalex.guiapi.view.GUIBase;
import org.bukkit.entity.Player;

public class GUICloseEvent<T extends GUIBase> extends GUIEventBase {

    public GUICloseEvent(T guiInstance, Player guiHolder) {
        super(guiInstance, guiHolder);
    }
}
