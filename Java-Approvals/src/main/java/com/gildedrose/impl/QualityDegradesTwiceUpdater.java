package com.gildedrose.impl;

import com.gildedrose.Item;
import com.gildedrose.service.QualityUpdater;
import com.gildedrose.util.GildedRoseUtil;


/**
 * The class QualityDegradesTwiceUpdater gives the implementation
 * to reduce quality twice when sellByDate is passed.
 */
public class QualityDegradesTwiceUpdater implements QualityUpdater {

    /**
     * Implementation to update the quality when sellByDate has passed.
     * @param item is the current item of the list.
     */
    @Override
    public void update(Item item) {
        if(item.sellIn <= 0){
            item.quality -= 2;
        }
        GildedRoseUtil.qualityCheck(item);
    }
}
