package com.gildedrose.impl;

import com.gildedrose.Item;
import com.gildedrose.service.QualityUpdater;
import com.gildedrose.util.GildedRoseUtil;

/**
 * The class ConjuredQualityUpdater gives the implementation to update Conjured Items Quality.
 */
public class ConjuredQualityUpdater implements QualityUpdater {
    /**
         * Implementation to update the quality of Conjured Items.
     * @param item is the current item of the list.
     */
    @Override
    public void update(Item item) {
        if(item.sellIn > 0){
            degradesQuality(item);
        }else{
            degradesWithSellByDatePassed(item);
        }
        GildedRoseUtil.qualityCheck(item);
    }

    /**
     * The degradesQuality method degrades the quality twice.
     * @param item is the current item of the list.
     */
    private void degradesQuality(Item item){
        if(item.quality <= 50){
            item.quality -= 2;
        }
    }

    /**
     * The degradesWithSellByDatePassed method degrades the quality four times
     * as the conjured Item quality degrades twice compared to normal items when sell by date is passed.
     * @param item is the current item of the list.
     */
    private void degradesWithSellByDatePassed(Item item){
        if(item.quality <= 50){
            item.quality -= 4;
        }
    }
}
