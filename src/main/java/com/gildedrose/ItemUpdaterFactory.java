package com.gildedrose;

public class ItemUpdaterFactory {

    static ItemUpdater getItemUpdater(Item item) {
        if (item instanceof ItemSulfuras) {
            return new ItemUpdaterSulfuras(item);
        }

        if (item instanceof ItemBackstagePasses) {
            return new ItemUpdaterBackstagePasses(item);
        }

        if (item instanceof ItemAgedBrie) {
            return new ItemUpdaterAgedBrie(item);
        }

        if (item instanceof ItemConjured) {
            return new ItemUpdaterConjured(item);
        }

        return new ItemUpdaterDefault(item);
    }
}
