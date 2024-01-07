package com.gildedtros;

public class SmellyItem extends InventoryItem {
    public SmellyItem(Item item) {
        super(item);
        setDecreaseValue(NORMAL_DECREASE_VALUE * 2);
    }

    @Override
    protected void updateQuality() {
        decreaseQuality();
    }

    @Override
    protected void updateQualityAfterExpiration() {
        decreaseQuality();
    }
}