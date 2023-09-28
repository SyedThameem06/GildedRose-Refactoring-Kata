package com.gildedrose.impl;

import com.gildedrose.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The ImprovesQualityWithAgeUpdaterTest class is Unit Test Class
 * to Test the features of {@link ImprovesQualityWithAgeUpdater}
 */
public class ImprovesQualityWithAgeUpdaterTest {

    @Test
    public void update(){
        ImprovesQualityWithAgeUpdater improvesQualityWithAgeUpdater;
        Item item;

        /*
          Check the normal behaviour to increment by 1 and
          if quality exceeds brings back to max quality 50.
         */
        item = new Item("Aged Brie, Ripped Mangoes", 10, 50);
        improvesQualityWithAgeUpdater = new ImprovesQualityWithAgeUpdater();
        improvesQualityWithAgeUpdater.update(item);
        Assertions.assertEquals(50, item.quality);

        /*
          Check the normal behaviour to increment by 1
         */
        item = new Item("Aged Brie, Ripped Mangoes", 10, 49);
        improvesQualityWithAgeUpdater = new ImprovesQualityWithAgeUpdater();
        improvesQualityWithAgeUpdater.update(item);
        Assertions.assertEquals(50, item.quality);
    }
}
