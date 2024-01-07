package com.gildedtros;

public abstract class InventoryItem {

    public static final int NORMAL_DECREASE_VALUE= 1;

    protected int decreaseValue;
    protected Item item;

    public InventoryItem(Item item) {
        this.item = item;
        decreaseValue = NORMAL_DECREASE_VALUE;
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

    protected void decreaseQuality() {
        if (item.quality > 0) {
            item.quality -= decreaseValue;
        }
    }

    public void setDecreaseValue(int decreaseValue) {
        this.decreaseValue = decreaseValue;
    }
}