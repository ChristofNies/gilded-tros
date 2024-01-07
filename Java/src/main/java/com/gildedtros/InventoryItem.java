package com.gildedtros;

public class InventoryItem {
    protected Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    public void dailyUpdate() {
        updateQuality();
        updateExpiration();

        if (item.sellIn < 0) {
            handleExpiredItems();
        }
    }

    protected void updateQuality() {
        if (isItemBackstagePasses()) {
            increaseQuality();

            if (item.sellIn < 11) {
                increaseQuality();
            }

            if (item.sellIn < 6) {
                increaseQuality();
            }
        } else if (!item.name.equals("B-DAWG Keychain")) {
            decreaseQuality();
        }
    }

    protected void updateExpiration() {
        if (!item.name.equals("B-DAWG Keychain")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    protected void handleExpiredItems() {
        if (isItemBackstagePasses()) {
            item.quality = 0;
        } else if (!item.name.equals("B-DAWG Keychain")) {
            decreaseQuality();
        }
    }

    private void decreaseQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    protected void increaseQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private boolean isItemBackstagePasses() {
        return item.name.startsWith("Backstage passes");
    }
}
