package com.gildedrose.impl;

import com.gildedrose.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The ConjuredQualityUpdaterTest class is Unit Test Class to Test the features of {@link ConjuredQualityUpdater}.
 */
public class ConjuredQualityUpdaterTest {

    @Test
    public void update() {
        ConjuredQualityUpdater conjuredQualityUpdater;
        Item item;

        /*
        Checks normal behaviour to degrade the product by two times
         */
        item = new Item("Conjured, Ripped Mangoes", 10, 50);
        conjuredQualityUpdater = new ConjuredQualityUpdater();
        conjuredQualityUpdater.update(item);
        Assertions.assertEquals(48,item.quality);

        /*
        Checks behaviour to degrade four times when sellIn value reaches concert.
         */
        item = new Item("Conjured, Ripped Mangoes", 0, 50);
        conjuredQualityUpdater = new ConjuredQualityUpdater();
        conjuredQualityUpdater.update(item);
        Assertions.assertEquals(46,item.quality);

        /*
        Checks behaviour to degrade four times when sellIn value reaches concert and
        if quality is less than 0 brings back to min quality 0.
         */
        item = new Item("Conjured, Ripped Mangoes", 0, 3);
        conjuredQualityUpdater = new ConjuredQualityUpdater();
        conjuredQualityUpdater.update(item);
        Assertions.assertEquals(0,item.quality);
    }
}
