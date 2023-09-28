package com.gildedrose;

import java.util.Arrays;

public class Program {

	public static void main(String... args) {
		System.out.println("OMGHAI!");

		Item[] items = new Item[] {
				new Item("+5 Dexterity Vest", 10, 20),
				new Item("Aged Brie", 2, 0),
				new Item("Elixir of the Mongoose", 5, 7),
				new Item("Sulfuras, Hand of Ragnaros", 0, 80),
				new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 35),
				new Item("Conjured Mana Cake", 3, 6) };

		GildedRose app = new GildedRose(items);

		for (int i = 0; i < 31; i++) {
			System.out.println("-------- day " + i + " --------");
			System.out.println("name, sellIn, quality");
            Arrays.stream(items).forEach(System.out::println);
			app.updateQuality();
		}
	}
}
