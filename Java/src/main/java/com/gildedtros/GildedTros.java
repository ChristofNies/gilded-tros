package com.gildedtros;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQuality(item);

            updateExpiration(item);

            handleExpiredItems(item);
        }
    }

    private void handleExpiredItems(Item item) {
        if (item.sellIn < 0) {
            if (item.name.equals("Good Wine")) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            } else if (isItemBackstagePasses(item)) {
                item.quality = 0;
            } else {
                if (item.quality > 0) {
                    if (!item.name.equals("B-DAWG Keychain")) {
                        item.quality = item.quality - 1;
                    }
                }
            }
        }
    }

    private void updateQuality(Item item) {
        if (item.name.equals("Good Wine")) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        } else if (isItemBackstagePasses(item)) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (isItemBackstagePasses(item)) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        } else if (!item.name.equals("B-DAWG Keychain")) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }

    private void updateExpiration(Item item) {
        if (!item.name.equals("B-DAWG Keychain")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private boolean isItemBackstagePasses(Item item) {
        return item.name.startsWith("Backstage passes");
    }
}