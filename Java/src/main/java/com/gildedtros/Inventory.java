package com.gildedtros;

public class Inventory {
    private Item item;

    public Inventory(Item item) {
        this.item = item;
    }

    public void dailyUpdate() {
        updateQuality();

        updateExpiration();

        handleExpiredItems();
    }

    private void handleExpiredItems() {
        if (item.sellIn < 0) {
            if (item.name.equals("Good Wine")) {
                increaseQuality();
            } else if (isItemBackstagePasses()) {
                item.quality = 0;
            } else if (!item.name.equals("B-DAWG Keychain")) {
                decreaseQuality();
            }
        }
    }

    private void decreaseQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void updateQuality() {
        if (item.name.equals("Good Wine")) {
            increaseQuality();
        } else if (isItemBackstagePasses()) {
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

    private void updateExpiration() {
        if (!item.name.equals("B-DAWG Keychain")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private boolean isItemBackstagePasses() {
        return item.name.startsWith("Backstage passes");
    }
}
