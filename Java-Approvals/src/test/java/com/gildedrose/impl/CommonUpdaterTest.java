package com.gildedrose.impl;

import com.gildedrose.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The CommonUpdaterTest test the feature of {@link CommonUpdaterTest}
 */
public class CommonUpdaterTest {

    @Test
    public void update(){
        CommonUpdater commonUpdater;
        Item item;

        /*
          Check the behaviour to increment by 1.
         */

        item = new Item("Chia Seeds", 40, 49);
        commonUpdater = new CommonUpdater();
        commonUpdater.update(item);
        Assertions.assertEquals(50, item.quality);

        /*
          Check the behaviour to increment by 1 and
          if quality exceeds brings back to max quality 50.
         */

        item = new Item("Chia Seeds", 40, 50);
        commonUpdater = new CommonUpdater();
        commonUpdater.update(item);
        Assertions.assertEquals(50, item.quality);

        /*
          Checks Sulfuras item not increases in quality.
         */

        item = new Item("Sulfuras, Chia Seeds", 40, 40);
        commonUpdater = new CommonUpdater();
        commonUpdater.update(item);
        Assertions.assertEquals(40, item.quality);
    }
}
