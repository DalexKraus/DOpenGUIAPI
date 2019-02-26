package at.dalex.guiapi.event;

import at.dalex.guiapi.view.GUIBase;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public abstract class GUIEventBase<T> extends Event {

    private T guiInstance;
    private Player guiHolder;

    public GUIEventBase(T guiInstance, Player guiHolder) {
        this.guiInstance = guiInstance;
        this.guiHolder = guiHolder;
    }

    public T getGuiInstance() {
        return this.guiInstance;
    }

    public Player getGuiHolder() {
        return this.guiHolder;
    }
}
