package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedTrosTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void updateQuality_decreases_quality_of_a_normal_item_by_1_every_day_before_its_sell_by_date() {
        Item[] items = new Item[] { new Item("Ring of Cleansening Code", 10, 20) };
        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(19, app.items[0].quality);
    }

    @Test
    void updateQuality_decreases_quality_of_a_normal_item_by_2_every_day_after_its_sell_by_date() {
        Item[] items = new Item[] { new Item("Ring of Cleansening Code", -1, 20) };
        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(18, app.items[0].quality);
    }

    @Test
    void updateQuality_quality_of_a_normal_item_never_decreases_below_0() {
        Item[] items = new Item[] { new Item("Ring of Cleansening Code", 10, 0) };
        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    void updateQuality_increases_quality_of_good_wine_by_1_every_day_it_gets_older_before_its_sell_by_date() {
        Item[] items = new Item[] { new Item("Good Wine", 2, 0) };
        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(1, app.items[0].quality);
    }

    @Test
    void updateQuality_increases_quality_of_good_wine_by_2_every_day_it_gets_older_after_its_sell_by_date() {
        Item[] items = new Item[] { new Item("Good Wine", -1, 0) };
        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(2, app.items[0].quality);
    }

    @Test
    void updateQuality_quality_of_non_legendary_items_can_not_be_more_than_50() {
        Item[] items = new Item[] {
                new Item("Good Wine", 2, 50),
                new Item("Backstage passes for Re:Factor", 10, 50) };
        GildedTros app = new GildedTros(items);

        app.updateQuality();

        for (int i = 0; i < items.length; i++) {
            assertEquals(50, app.items[i].quality);
        }
    }

    @Test
    void updateQuality_sellIn_decreases_for_all_non_legendary_items_each_day() {
        Item[] items = new Item[] {
                new Item("Ring of Cleansening Code", 10, 20),
                new Item("Good Wine", 2, 50),
                new Item("Backstage passes for Re:Factor", 10, 50) };
        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(1, app.items[1].sellIn);
        assertEquals(9, app.items[2].sellIn);
    }

    @Test
    void updateQuality_never_decreases_quality_of_legendary_items() {
        Item[] items = new Item[] { new Item("B-DAWG Keychain", 0, 80) };
        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(80, app.items[0].quality);
    }

    @Test
    void updateQuality_never_decreases_sellIn_of_legendary_items() {
        Item[] items = new Item[] { new Item("B-DAWG Keychain", 0, 80) };
        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    void updateQuality_increases_quality_of_backstage_passes_by_1_every_day_more_than_10_days_before_its_sell_by_date() {
        Item[] items = new Item[] { new Item("Backstage passes for Re:Factor", 11, 10), };
        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(11, app.items[0].quality);
    }

    @Test
    void updateQuality_increases_quality_of_backstage_passes_by_2_every_day_between_10_and_5_days_before_its_sell_by_date() {
        Item[] items = new Item[] { new Item("Backstage passes for Re:Factor", 10, 10), };
        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(12, app.items[0].quality);
    }

    @Test
    void updateQuality_increases_quality_of_backstage_passes_by_3_every_day_within_5_days_before_its_sell_by_date() {
        Item[] items = new Item[] { new Item("Backstage passes for HAXX", 4, 10), };
        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(13, app.items[0].quality);
    }

    @Test
    void updateQuality_drops_quality_of_backstage_passes_to_0_after_its_sell_by_date() {
        Item[] items = new Item[] { new Item("Backstage passes for Re:Factor", 0, 10), };
        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    void texttest_day_1_for_list_of_items() {
        Item[] items = getItems();
        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
        assertEquals(1, app.items[1].sellIn);
        assertEquals(1, app.items[1].quality);
        assertEquals(4, app.items[2].sellIn);
        assertEquals(6, app.items[2].quality);
        assertEquals(0, app.items[3].sellIn);
        assertEquals(80, app.items[3].quality);
        assertEquals(-1, app.items[4].sellIn);
        assertEquals(80, app.items[4].quality);
        assertEquals(14, app.items[5].sellIn);
        assertEquals(21, app.items[5].quality);
        assertEquals(9, app.items[6].sellIn);
        assertEquals(50, app.items[6].quality);
        assertEquals(4, app.items[7].sellIn);
        assertEquals(50, app.items[7].quality);
    }

    @Test
    void texttest_day_10_for_list_of_items() {
        Item[] items = getItems();
        GildedTros app = new GildedTros(items);

        for (int i = 0; i < 10; i++) {
            app.updateQuality();
        }

        assertEquals(0, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
        assertEquals(-8, app.items[1].sellIn);
        assertEquals(18, app.items[1].quality);
        assertEquals(-5, app.items[2].sellIn);
        assertEquals(0, app.items[2].quality);
        assertEquals(0, app.items[3].sellIn);
        assertEquals(80, app.items[3].quality);
        assertEquals(-1, app.items[4].sellIn);
        assertEquals(80, app.items[4].quality);
        assertEquals(5, app.items[5].sellIn);
        assertEquals(35, app.items[5].quality);
        assertEquals(0, app.items[6].sellIn);
        assertEquals(50, app.items[6].quality);
        assertEquals(-5, app.items[7].sellIn);
        assertEquals(0, app.items[7].quality);
    }

    @Test
    void texttest_day_20_for_list_of_items() {
        Item[] items = getItems();
        GildedTros app = new GildedTros(items);

        for (int i = 0; i < 20; i++) {
            app.updateQuality();
        }

        assertEquals(-10, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        assertEquals(-18, app.items[1].sellIn);
        assertEquals(38, app.items[1].quality);
        assertEquals(-15, app.items[2].sellIn);
        assertEquals(0, app.items[2].quality);
        assertEquals(0, app.items[3].sellIn);
        assertEquals(80, app.items[3].quality);
        assertEquals(-1, app.items[4].sellIn);
        assertEquals(80, app.items[4].quality);
        assertEquals(-5, app.items[5].sellIn);
        assertEquals(0, app.items[5].quality);
        assertEquals(-10, app.items[6].sellIn);
        assertEquals(0, app.items[6].quality);
        assertEquals(-15, app.items[7].sellIn);
        assertEquals(0, app.items[7].quality);
    }

    @Test
    void updateQuality_decreases_smelly_items_twice_as_fast_as_normal_item_before_its_sell_by_date() {
        Item[] items = new Item[] { new Item("Duplicate Code",  1, 20),
                new Item("Long Methods", 10, 10),
                new Item("Ugly Variable Names", 5, 26) };
        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(18, app.items[0].quality);
        assertEquals(8, app.items[1].quality);
        assertEquals(24, app.items[2].quality);
    }

    @Test
    void updateQuality_decreases_smelly_items_twice_as_fast_as_normal_item_after_its_sell_by_date() {
        Item[] items = new Item[] { new Item("Duplicate Code", -1, 20),
                new Item("Long Methods", -10, 10),
                new Item("Ugly Variable Names", -5, 26) };
        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(16, app.items[0].quality);
        assertEquals(6, app.items[1].quality);
        assertEquals(22, app.items[2].quality);
    }

    @Test
    void updateQuality_smelly_items_can_not_be_negative() {
        Item[] items = new Item[] { new Item("Duplicate Code", 10, 0) };
        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    private Item[] getItems() {
        return new Item[]{
                new Item("Ring of Cleansening Code", 10, 20),
                new Item("Good Wine", 2, 0),
                new Item("Elixir of the SOLID", 5, 7),
                new Item("B-DAWG Keychain", 0, 80),
                new Item("B-DAWG Keychain", -1, 80),
                new Item("Backstage passes for Re:Factor", 15, 20),
                new Item("Backstage passes for Re:Factor", 10, 49),
                new Item("Backstage passes for HAXX", 5, 49)};
    }
}
