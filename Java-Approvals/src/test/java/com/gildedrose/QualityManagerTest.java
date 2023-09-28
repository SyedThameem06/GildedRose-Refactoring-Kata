package com.gildedrose;

import com.gildedrose.impl.*;
import com.gildedrose.service.QualityUpdater;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QualityManagerTest {


    @Test
    public void updater(){
        Item item;
        QualityUpdater qualityUpdater;

        item = new Item("Conjured, Ripped Mangoes", 10, 50);
        qualityUpdater = QualityManager.updater(item);
        Assertions.assertEquals(qualityUpdater.getClass(),ConjuredQualityUpdater.class);

        item = new Item("Backstage passes, Chia Seeds", 40, 49);
        qualityUpdater = QualityManager.updater(item);
        Assertions.assertEquals(qualityUpdater.getClass(), BackStagePassesUpdater.class);

        item = new Item("Aged Brie, Chia Seeds", 40, 49);
        qualityUpdater = QualityManager.updater(item);
        Assertions.assertEquals(qualityUpdater.getClass(), ImprovesQualityWithAgeUpdater.class);

        item = new Item("Chia Seeds", 0, 49);
        qualityUpdater = QualityManager.updater(item);
        Assertions.assertEquals(qualityUpdater.getClass(), QualityDegradesTwiceUpdater.class);

        item = new Item("Chia Seeds", 10, 49);
        qualityUpdater = QualityManager.updater(item);
        Assertions.assertEquals(qualityUpdater.getClass(), CommonUpdater.class);
    }
}
