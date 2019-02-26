package at.dalex.guiapi.event;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class GUIClickEvent<T> extends GUIEventBase {

    private static HandlerList handlers = new HandlerList();
    private ItemStack clickedItem;

    public GUIClickEvent(Object guiInstance, Player guiHolder, ItemStack clickedItem) {
        super(guiInstance, guiHolder);
        this.clickedItem = clickedItem;
    }

    public ItemStack getClickedItem() {
        return this.clickedItem;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
