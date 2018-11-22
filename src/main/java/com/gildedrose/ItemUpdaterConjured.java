package com.gildedrose;

public class ItemUpdaterConjured extends ItemUpdaterDefault {

    ItemUpdaterConjured(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality(Item item) {
        item.quality = item.quality - 2;
        if (item.sellIn <= 0) {
            item.quality = item.quality - 2;
        }
        if (item.quality < 0) {
            item.quality = 0;
        }
    }
}
