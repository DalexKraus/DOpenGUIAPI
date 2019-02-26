package at.dalex.guiapi.event;

import at.dalex.guiapi.view.GUIBase;
import org.bukkit.event.Event;

public abstract class GUIEventBase<T> extends Event {

    public T guiInstance;

    public GUIEventBase(T guiInstance) {
        this.guiInstance = guiInstance;
    }

    public T getGuiInstance() {
        return this.guiInstance;
    }
}
