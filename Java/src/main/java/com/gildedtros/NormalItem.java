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
    protected void updateExpiration() {
        super.updateExpiration();
    }

    @Override
    protected void handleExpiredItems() {
        decreaseQuality();
    }

    private void decreaseQuality() {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
