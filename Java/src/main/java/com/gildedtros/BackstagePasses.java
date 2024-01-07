package com.gildedtros;

public class BackstagePasses extends InventoryItem {

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();

        if (item.sellIn < 11) {
            increaseQuality();
        }

        if (item.sellIn < 6) {
            increaseQuality();
        }
    }

    @Override
    protected void updateQualityAfterExpiration() {
        item.quality = 0;
    }
}
