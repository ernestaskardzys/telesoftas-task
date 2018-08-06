package info.ernestas.gildedrose.kata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GildedRoseTest {

    private GildedRose gildedRose;

    private Item item;
    private Item result;

    public GildedRoseTest(Item input, Item expected) {
        this.item = input;
        this.result = expected;
    }

    @Parameterized.Parameters(name = "{index}: updateQuality({0})={1}")
    public static Collection<Item[]> data() {
        return Arrays.asList(new Item[][] {
                {
                    new Item("+5 Dexterity Vest", 10, 20),
                    new Item("+5 Dexterity Vest", 9, 19)
                },
                {
                    new Item("Aged Brie", 2, 0),
                    new Item("Aged Brie", 1, 1),
                },
                {
                    new Item("Elixir of the Mongoose", 5, 7),
                    new Item("Elixir of the Mongoose", 4, 6),
                },
                {
                    new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                    new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                },
                {
                    new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                    new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                },
                {
                    new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21),
                },
                {
                    new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 9, 50),
                },
                {
                    new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
                },
                {
                    // this conjured item does not work properly yet
                    new Item("Conjured Mana Cake", 3, 6),
                    new Item("Conjured Mana Cake", 2, 5)
                }
        });
    }

    @Test
    public void test() {
        final Item[] items = { item };
        gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(result.name, items[0].name);
        assertEquals(result.sellIn, items[0].sellIn);
        assertEquals(result.quality, items[0].quality);
    }

}
