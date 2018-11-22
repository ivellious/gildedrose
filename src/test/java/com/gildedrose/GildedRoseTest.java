package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GildedRoseTest {

    private static final String TEST_NAME = "testName";
    private static final String AGED_BRIE_NAME = "Aged Brie";
    private static final String SULFURAS_NAME = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES_NAME = "Backstage passes to a TAFKAL80ETC concert";
    private static final String CONJURED_NAME = "Conjured Mana Cake";

    private int originalQuality;
    private int originalSellIn;

    @Test
    public void systemLowersBothValuesForNormalItem() {
        Item item = new Item(TEST_NAME, 2, 10);
        originalSellIn = item.sellIn;
        Item[] items = new Item[]{item};
        originalQuality = item.quality;
        new GildedRose(items).updateQuality();
        assertTrue(originalSellIn > item.sellIn && originalQuality > item.quality);
    }

    @Test
    public void qualityDegradesTwiceFasterWhenSellInIsZero() {
        Item item = new Item(TEST_NAME, 1, 10);
        Item[] items = new Item[]{item};
        originalQuality = item.quality;
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(originalQuality, item.quality + 1);
        app.updateQuality();
        assertEquals(originalQuality, item.quality + 3);
    }

    @Test
    public void qualityIsNeverNegative() {
        Item item = new Item(TEST_NAME, 0, 0);
        Item[] items = new Item[]{item};
        new GildedRose(items).updateQuality();
        assertTrue(item.quality >= 0);
    }

    @Test
    public void agedBrieQualityIncreasesIfSellInDecreases() {
        Item item = new Item(AGED_BRIE_NAME, 0, 2);
        Item[] items = new Item[]{item};
        originalQuality = item.quality;
        new GildedRose(items).updateQuality();
        assertTrue(originalQuality < item.quality);
    }

    @Test
    public void agedBrieQualityIsNeverMoreThan50() {
        Item item = new Item(AGED_BRIE_NAME, 0, 50);
        Item[] items = new Item[]{item};
        originalQuality = item.quality;
        new GildedRose(items).updateQuality();
        assertEquals(originalQuality, item.quality);
    }

    @Test
    public void sulfurasQualitySellInNeverChanges() {
        Item item = new Item(SULFURAS_NAME, 10,80);
        Item[] items = new Item[]{item};
        originalQuality = item.quality;
        originalSellIn = item.sellIn;
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(originalQuality, item.quality);
        assertEquals(originalSellIn, item.sellIn);
    }

    @Test
    public void backstagePassesQualityIs0IfSellInIs0() {
        Item item = new Item(BACKSTAGE_PASSES_NAME, 0, 10);
        Item[] items = new Item[]{item};
        new GildedRose(items).updateQuality();
        assertEquals(0, item.quality);
    }

    @Test
    public void backstagePassesQualityIncreasesBy2IfSellInIsLessThan11() {
        Item item = new Item(BACKSTAGE_PASSES_NAME, 9, 20);
        Item[] items = new Item[]{item};
        originalQuality = item.quality;
        new GildedRose(items).updateQuality();
        assertEquals(originalQuality, item.quality-2);
    }

    @Test
    public void backstagePassesQualityIncreasesBy3IfSellInIsLessThan6() {
        Item item = new Item(BACKSTAGE_PASSES_NAME, 5, 10);
        Item[] items = new Item[]{item};
        originalQuality = item.quality;
        new GildedRose(items).updateQuality();
        assertEquals(originalQuality, item.quality-3);

    }

    //@Test

    public void conjuredDeqradeQualityTwiceFasterThanNormal() {
        Item item = new Item(TEST_NAME, 10,10);
        Item conjuredItem = new Item(CONJURED_NAME, 10,10);
        Item[] items = new Item[] {item, conjuredItem};
        new GildedRose(items).updateQuality();
        assertEquals(item.quality, conjuredItem.quality-1);
    }
}

