package com.gildedrose.util;

import com.gildedrose.Item;

public class GildedRoseUtil {

    public static void qualityCheck(Item item) {
        if(item.quality > 50)
            item.quality = 50;
        if(item.quality < 0)
            item.quality = 0;
    }
}
