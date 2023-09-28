package com.gildedrose.impl;

import com.gildedrose.Item;
import com.gildedrose.service.QualityUpdater;
import com.gildedrose.util.GildedRoseUtil;

/**
 * The class ImprovesQualityWithAgeUpdater gives the implementation to update Aged Brie Items Quality.
 */
public class ImprovesQualityWithAgeUpdater implements QualityUpdater {

    /**
     * Implementation to update the quality of Aged Brie Items.
     * @param item is the current item of the list.
     */
    @Override
    public void update(Item item) {
        item.quality++;
        GildedRoseUtil.qualityCheck(item);
    }
}
