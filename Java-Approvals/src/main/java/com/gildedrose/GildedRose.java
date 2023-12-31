package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.asList(items).forEach(item -> {
            QualityManager.updater(item).update(item);
            item.sellIn--;
        });
    }
}
