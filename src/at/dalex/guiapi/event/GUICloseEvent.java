package at.dalex.guiapi.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GUICloseEvent<T> extends GUIEventBase {

    private static HandlerList handlers = new HandlerList();
    private T closedGUIInstance;

    public GUICloseEvent(T guiInstance, Player guiHolder) {
        super(guiInstance, guiHolder);
    }

}
