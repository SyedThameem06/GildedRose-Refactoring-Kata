package com.gildedrose.impl;

import com.gildedrose.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The QualityDegradesTwiceUpdaterTest class is Unit Test Class
 * to Test the features of {@link QualityDegradesTwiceUpdater}
 */
public class QualityDegradesTwiceUpdaterTest {

    @Test
    public void update(){
        QualityDegradesTwiceUpdater qualityDegradesTwiceUpdater;
        Item item;

        /*
        Checks the normal behaviour to decrease the quality two times when sellByDate is passed
         */
        item = new Item("Ripped Mangoes", 0, 50);
        qualityDegradesTwiceUpdater = new QualityDegradesTwiceUpdater();
        qualityDegradesTwiceUpdater.update(item);
        Assertions.assertEquals(48, item.quality);

        /*
        Checks the normal behaviour to decrease the quality two times when sellByDate is passed
        and  if quality is less than 0 brings back to min quality 0.
         */
        item = new Item("Ripped Mangoes", 0, 0);
        qualityDegradesTwiceUpdater = new QualityDegradesTwiceUpdater();
        qualityDegradesTwiceUpdater.update(item);
        Assertions.assertEquals(0, item.quality);
    }
}
