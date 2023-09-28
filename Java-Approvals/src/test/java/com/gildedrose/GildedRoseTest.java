package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GildedRoseTest {

	@Test
    public void verifyBackStagePasses() {
        GildedRose gildedRose;
        Item[] expectedItems;
        Item[] items = new Item[] {
            new Item("Backstage passes, Chia Seeds", 40, 49),
            new Item("Backstage passes, Chia Seeds", 9, 49),
            new Item("Backstage passes, Chia Seeds", 9, 20),
            new Item("Backstage passes, Chia Seeds", 4, 20)
        };

        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        expectedItems = items;
        Assertions.assertArrayEquals(expectedItems, items);
         /*
          Checks the normal behaviour to increment by 1.
         */
        Assertions.assertEquals(50, items[0].quality);
        /*
          Check the behaviour to increment by 2 and
          if quality exceeds brings back to max quality 50.
         */
        Assertions.assertEquals(50, items[1].quality);
        /*
          Check the behaviour to increment by 2.
         */
        Assertions.assertEquals(22, items[2].quality);
        /*
          Check the behaviour to increment by 3.
         */
        Assertions.assertEquals(23, items[3].quality);
    }

    @Test
    public void verifyConjured(){
        GildedRose gildedRose;
        Item[] expectedItems;

        Item[] items = new Item[] {
            new Item("Conjured, Ripped Mangoes", 10, 50),
            new Item("Conjured, Ripped Mangoes", 0, 50),
            new Item("Conjured, Ripped Mangoes", 0, 3)
        };

        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        expectedItems = items;
        Assertions.assertArrayEquals(expectedItems, items);

        /*
        Checks normal behaviour to degrade the product by two times
         */
        Assertions.assertEquals(48,items[0].quality);
        /*
        Checks behaviour to degrade four times when sellIn value reaches concert.
         */
        Assertions.assertEquals(46,items[1].quality);
         /*
        Checks behaviour to degrade four times when sellIn value reaches concert and
        if quality is less than 0 brings back to min quality 0.
         */
        Assertions.assertEquals(0,items[2].quality);
    }

    @Test
    public void verifyImprovesQualityWithAge() {

        GildedRose gildedRose;
        Item[] expectedItems;

        Item[] items = new Item[] {
            new Item("Aged Brie, Ripped Mangoes", 10, 50),
            new Item("Aged Brie, Ripped Mangoes", 10, 49)
        };

        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        expectedItems = items;
        Assertions.assertArrayEquals(expectedItems, items);

        /*
          Check the normal behaviour to increment by 1 and
          if quality exceeds brings back to max quality 50.
         */
        Assertions.assertEquals(50, items[0].quality);

        /*
          Check the normal behaviour to increment by 1
         */
        Assertions.assertEquals(50, items[0].quality);
    }

    @Test
    public void verifyDegradesTwice() {

        GildedRose gildedRose;
        Item[] expectedItems;

        Item[] items = new Item[] {
            new Item("Ripped Mangoes", 0, 50),
            new Item("Ripped Mangoes", 0, 0)
        };

        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        expectedItems = items;
        Assertions.assertArrayEquals(expectedItems, items);

        /*
        Checks the normal behaviour to decrease the quality two times when sellByDate is passed
         */
        Assertions.assertEquals(48, items[0].quality);

        /*
        Checks the normal behaviour to decrease the quality two times when sellByDate is passed
        and  if quality is less than 0 brings back to min quality 0.
         */
        Assertions.assertEquals(0, items[1].quality);
    }

    @Test
    public void verifyQualityNotDegradesForSulfuras() {

        GildedRose gildedRose;
        Item[] expectedItems;

        Item[] items = new Item[] {
            new Item("Sulfuras, Ripped Mangoes", 0, 50),
            new Item("Sulfuras, Ripped Mangoes", 0, 10)
        };

        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        expectedItems = items;
        Assertions.assertArrayEquals(expectedItems, items);

        Assertions.assertEquals(50, items[0].quality);
        Assertions.assertEquals(10, items[1].quality);
    }
}
