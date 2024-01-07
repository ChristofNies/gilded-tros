package com.gildedtros;

public class Inventory {
    private Inventory() { }

    public static InventoryItem createInventoryItem(Item item) {
        if (isAgingItem(item)) {
            return new AgingItem(item);
        } else if (isItemBackstagePasses(item)) {
            return new BackstagePasses(item);
        } else if (isLegendaryItem(item)) {
            return new LegendaryItem(item);
        } else if (isSmellyItem(item)) {
            return new SmellyItem(item);
        }

        return new NormalItem(item);
    }

    private static boolean isAgingItem(Item item) {
        return item.name.equals("Good Wine");
    }

    private static boolean isSmellyItem(Item item) {
        return item.name.equals("Duplicate Code")
                || item.name.equals("Long Methods")
                || item.name.equals("Ugly Variable Names");
    }

    private static boolean isLegendaryItem(Item item) {
        return item.name.equals("B-DAWG Keychain");
    }

    private static boolean isItemBackstagePasses(Item item) {
        return item.name.startsWith("Backstage passes");
    }
}
