package com.gildedrose.impl;

import com.gildedrose.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The BackStagePassedUpdaterTest test the feature of {@link BackStagePassesUpdater}
 */
public class BackStagePassedUpdaterTest {

    @Test
    public void update(){
        BackStagePassesUpdater backStagePassesUpdater;
        Item item;

        /*
          Checks the normal behaviour to increment by 1.
         */
        item = new Item("Backstage passes Chia Seeds", 40, 49);
        backStagePassesUpdater = new BackStagePassesUpdater();
        backStagePassesUpdater.update(item);
        Assertions.assertEquals(50, item.quality);

        /*
          Check the behaviour to increment by 2 and
          if quality exceeds brings back to max quality 50.
         */
        item = new Item("Backstage passes, Chia Seeds", 9, 49);
        backStagePassesUpdater = new BackStagePassesUpdater();
        backStagePassesUpdater.update(item);
        Assertions.assertEquals(50, item.quality);

        /*
          Check the behaviour to increment by 2.
         */
        item = new Item("Backstage passes, Chia Seeds", 9, 20);
        backStagePassesUpdater = new BackStagePassesUpdater();
        backStagePassesUpdater.update(item);
        Assertions.assertEquals(22, item.quality);

        /*
          Check the behaviour to increment by 3.
         */
        item = new Item("Backstage passes, Chia Seeds", 4, 20);
        backStagePassesUpdater = new BackStagePassesUpdater();
        backStagePassesUpdater.update(item);
        Assertions.assertEquals(23, item.quality);
    }
}
