package com.gildedrose;

import com.gildedrose.impl.*;
import com.gildedrose.service.QualityUpdater;

/**
 * The QualityUpdater class is used to update the quality of an Item.
 * @author Syed Thameem
 * @version 1.1
 */
public class QualityManager {

    public static QualityUpdater updater(Item item){
        if(isConjured(item)) {
            return new ConjuredQualityUpdater();
        } else if(isBackstagePasses(item)) {
            return new BackStagePassesUpdater();
        } else if(qualityImprovesWithAge(item)) {
            return new ImprovesQualityWithAgeUpdater();
        } else if (qualityDegradesTwice(item)) {
            return new QualityDegradesTwiceUpdater();
        } else {
            return new CommonUpdater();
        }
    }

    /**
     * The qualityImprovesWithAge method decides to improve the quality of an Item based on Aged Brie Items.
     * @param item is the current item of the list.
     * @return boolean value based on item name "Aged Brie".
     */
    private static boolean qualityImprovesWithAge(Item item) {
        return item.name.contains("Aged Brie");
    }

    /**
     * The qualityDegradesTwice method decides to degrade quality twice once the sell by date is passed.
     * @param item is the current item of the list.
     * @return boolean value based on item sellin value.
     */
    private static boolean qualityDegradesTwice(Item item) {
        return item.sellIn <=0 && !isLegendary(item);
    }

    /**
     *  isBackstagePasses method decides to increases in Quality as its SellIn value approaches;
     * 	Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
     * 	Quality drops to 0 after the concert.
     * @param item is the current item of the list.
     * @return boolean value based on item name "Backstage passes".
     */
    private static boolean isBackstagePasses(Item item) {
        return item.name.contains("Backstage passes");
    }

    /**
     * isConjured method decides to degrade in Quality twice as fast as normal items
     * @param item is the current item of the list.
     * @return boolean value based on item name "Conjured".
     */
    private static boolean isConjured(Item item){
        return item.name.contains("Conjured");
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
