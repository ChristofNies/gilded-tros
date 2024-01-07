package com.gildedtros;

public abstract class InventoryItem {
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

    protected void updateExpiration() {
        if (!Inventory.isLegendaryItem(item)) {
            item.sellIn--;
        }
    }

    protected abstract void updateQuality();

    protected abstract void handleExpiredItems();

    protected void increaseQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}