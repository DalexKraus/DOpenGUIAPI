package at.dalex.guiapi.event;

import org.bukkit.event.HandlerList;

public class GUIClickEvent<T> extends GUIEventBase {

    private static HandlerList handlers = new HandlerList();

    public GUIClickEvent(Object guiInstance) {
        super(guiInstance);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
