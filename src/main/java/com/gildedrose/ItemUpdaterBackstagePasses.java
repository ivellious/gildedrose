package com.gildedrose;

public class ItemUpdaterBackstagePasses extends ItemUpdaterDefault {

    ItemUpdaterBackstagePasses(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality(Item item) {
        if (item.sellIn > 10) {
            item.quality++;
        } else if (item.sellIn > 5) {
            item.quality = item.quality + 2;
        } else if (item.sellIn > 0) {
            item.quality = item.quality + 3;
        } else {
            item.quality = 0;
        }

        if (item.quality > 50) {
            item.quality = 50;
        }
    }
}
