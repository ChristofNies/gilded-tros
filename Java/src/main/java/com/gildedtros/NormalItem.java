package com.gildedtros;

public class NormalItem extends InventoryItem {
    public NormalItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        decreaseQuality();
    }

    @Override
    protected void updateSellIn() {
        super.updateSellIn();
    }

    @Override
    protected void updateQualityAfterExpiration() {
        decreaseQuality();
    }
}
