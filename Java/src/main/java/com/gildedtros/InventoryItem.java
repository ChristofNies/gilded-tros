package com.gildedtros;

public class InventoryItem {
    protected Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    public void performDailyUpdate() {
        updateQuality();
        updateExpiration();

        if (item.sellIn < 0) {
            handleExpiredItems();
        }
    }

    protected void updateQuality() {
        if (item.name.equals("B-DAWG Keychain")) {
            return;
        }
    }

    protected void updateExpiration() {
        if (item.name.equals("B-DAWG Keychain")) {
            return;
        }

        item.sellIn = item.sellIn - 1;
    }

    protected void handleExpiredItems() {
        if (item.name.equals("B-DAWG Keychain")) {
            return;
        }
    }

    protected void increaseQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}