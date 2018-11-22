package com.gildedrose;

public class ItemUpdaterAgedBrie extends ItemUpdaterDefault {

    ItemUpdaterAgedBrie(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality(Item item) {
        item.quality++;
        if (item.sellIn <= 0) {
            item.quality++;
        }
        if (item.quality > 50) {
            item.quality = 50;
        }
    }
}
