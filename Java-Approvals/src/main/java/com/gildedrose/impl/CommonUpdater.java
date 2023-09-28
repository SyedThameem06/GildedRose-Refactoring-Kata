package com.gildedrose.impl;

import com.gildedrose.Item;
import com.gildedrose.service.QualityUpdater;
import com.gildedrose.util.GildedRoseUtil;

/**
 * The class CommonUpdater gives the implementation  to update Items Quality.
 */
public class CommonUpdater implements QualityUpdater {

    /**
     * Implementation to update the quality of Items.
     * @param item is the current item of the list.
     */
    @Override
    public void update(Item item) {
        if(!isLegendary(item)){
            item.quality++;
            GildedRoseUtil.qualityCheck(item);
        }
    }

    /**
     * isLegendary method decides not to decrease the item's quality.
     * @param item is the current item of the list.
     * @return boolean value based on item name "Sulfuras".
     */
    private static boolean isLegendary(Item item) {
        return item.name.contains("Sulfuras");
    }
}
