package com.gildedtros;

public class LegendaryItem extends InventoryItem {
    public LegendaryItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() { }

    @Override
    protected void updateSellIn() { }

    @Override
    protected void updateQualityAfterExpiration() { }
}
