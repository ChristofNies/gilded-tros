package com.gildedtros;

public class Inventory {
    private Item item;

    public Inventory(Item item) {
        this.item = item;
    }

    public InventoryItem getInventoryItem() {
        if (item.name.equals("Good Wine")) {
            return new AgingItem(item);
        }

        return new InventoryItem(item);
    }
}
