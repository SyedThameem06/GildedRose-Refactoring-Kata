package com.gildedrose.impl;

import com.gildedrose.Item;
import com.gildedrose.service.QualityUpdater;
import com.gildedrose.util.GildedRoseUtil;

/**
 * The class BackStagePassesUpdater gives the implementation
 * to update Backstage passes Items Quality.
 */
public class BackStagePassesUpdater implements QualityUpdater {

    /**
     * Implementation to update the quality of Backstage Passes Items.
     * @param item is the current item of the list.
     */
    @Override
    public void update(Item item) {
        if(isSellInConcert(item)){
            item.quality = 0;
        }else if(item.quality < 50){
            item.quality += increaseQuality(item);
        }
        GildedRoseUtil.qualityCheck(item);
    }

    /**
     * The increaseQuality method increment the quality;
     * Quality increases by 2 when there are 10 days or less
     * and by 3 when there are 5 days or less but
     * @param item is the current item of the list.
     * @return incremental value of the quality.
     */
    private int increaseQuality(Item item){
        int incrementQualityBy3 = 3;
        int incrementQualityBy2 = 2;
        int incrementQualityBy1 = 1;

        if(item.sellIn > 0 && item.sellIn <= 5){
            return incrementQualityBy3;
        }else if(item.sellIn > 5 && item.sellIn <= 10){
            return incrementQualityBy2;
        }
        return incrementQualityBy1;
    }

    /**
     * isSellInConcert decides whether sellIn value reached its concert.
     * @param item is the current item of the list.
     * @return boolean based on sellIn
     */
    private boolean isSellInConcert(Item item){
        return item.sellIn <= 0;
    }
}
