package com.gildedrose.service;

import com.gildedrose.Item;

/**
 * The QualityUpdater Interface should be implemented by any class
 * whose instances are intended to update the quality of an Item.
 */
public interface QualityUpdater {
    /**
     * When an object implementing interface QualityUpdater,
     * causes the update method to be called for updating the quality of an Item.
     * @param item is the current item of the list.
     */
    void update(Item item);
}
