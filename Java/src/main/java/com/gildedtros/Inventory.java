package com.gildedtros;

public class Inventory {
    private Inventory() { }

    public static InventoryItem createInventoryItem(Item item) {
        if (item.name.equals("Good Wine")) {
            return new AgingItem(item);
        } else if (isItemBackstagePasses(item)) {
            return new BackstagePasses(item);
        }

        return new InventoryItem(item);
    }

    private static boolean isItemBackstagePasses(Item item) {
        return item.name.startsWith("Backstage passes");
    }
}
