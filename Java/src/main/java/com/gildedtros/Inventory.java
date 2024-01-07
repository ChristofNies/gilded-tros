package com.gildedtros;

public class Inventory {
    private Inventory() { }

    public static InventoryItem createInventoryItem(Item item) {
        if (item.name.equals("Good Wine")) {
            return new AgingItem(item);
        } else if (isItemBackstagePasses(item)) {
            return new BackstagePasses(item);
        } if (isLegendaryItem(item)) {
            return new LegendaryItem(item);
        }

        return new NormalItem(item);
    }

    public static boolean isLegendaryItem(Item item) {
        return item.name.equals("B-DAWG Keychain");
    }

    private static boolean isItemBackstagePasses(Item item) {
        return item.name.startsWith("Backstage passes");
    }
}
