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
    protected void updateQualityAfterExpiration() {
        increaseQuality();
    }
}
