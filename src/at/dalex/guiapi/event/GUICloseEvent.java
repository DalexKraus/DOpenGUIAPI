package at.dalex.guiapi.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GUICloseEvent<T> extends GUIEventBase {

    private static HandlerList handlers = new HandlerList();
    private T closedGUIInstance;

    public GUICloseEvent(Object guiInstance) {
        super(guiInstance);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
