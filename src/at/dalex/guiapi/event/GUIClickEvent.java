package at.dalex.guiapi.event;

import at.dalex.guiapi.view.GUIBase;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GUIClickEvent<T extends GUIBase> extends GUIEventBase {

    private ItemStack clickedItem;

    public GUIClickEvent(T guiInstance, Player guiHolder, ItemStack clickedItem) {
        super(guiInstance, guiHolder);
        this.clickedItem = clickedItem;
    }

    public ItemStack getClickedItem() {
        return this.clickedItem;
    }
}
