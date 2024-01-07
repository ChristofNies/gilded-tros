package com.gildedtros;

public class AgingItem extends InventoryItem {

    public AgingItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
    }

    @Override
    protected void updateExpiration() {
        item.sellIn--;
    }

    @Override
    protected void handleExpiredItems() {
        increaseQuality();
    }
}
