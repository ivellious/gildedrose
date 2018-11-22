package com.gildedrose;

public class ItemUpdaterDefault implements ItemUpdater {

    private Item item;

    ItemUpdaterDefault(Item item) {
        this.item = item;
    }

    @Override
    public void updateValueOfItem() {
        updateQuality(item);
        updateSellIn(item);
    }

    protected void updateQuality(Item item) {
        item.quality--;
        if (item.sellIn <= 0) {
            item.quality--;
        }
        if (item.quality < 0) {
            item.quality = 0;
        }
    }

    private void updateSellIn(Item item) {
        item.sellIn--;
    }
}
