package info.ernestas.gildedrose.kata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GildedRoseTest {

    private GildedRose gildedRose;

    private Item item;
    private Item firstDay;
    private Item secondDay;
    private Item[] items;
    private final Item ninetyNineDay;

    public GildedRoseTest(Item input, Item firstDay, Item secondDay, Item ninetyNineDay) {
        this.item = input;
        this.firstDay = firstDay;
        this.secondDay = secondDay;
        this.ninetyNineDay = ninetyNineDay;
    }

    @Parameterized.Parameters(name = "{index}: updateQuality({0})={1}")
    public static Collection<Item[]> data() {
        return Arrays.asList(new Item[][] {
                {
                    new Item("+5 Dexterity Vest", 10, 20),
                    new Item("+5 Dexterity Vest", 9, 19),
                    new Item("+5 Dexterity Vest", 8, 18),
                    new Item("+5 Dexterity Vest", -89, 0)
                },
                {
                    new Item("Aged Brie", 2, 0),
                    new Item("Aged Brie", 1, 1),
                    new Item("Aged Brie", 0, 2),
                    new Item("Aged Brie", -97, 50)
                },
                {
                    new Item("Elixir of the Mongoose", 5, 7),
                    new Item("Elixir of the Mongoose", 4, 6),
                    new Item("Elixir of the Mongoose", 3, 5),
                    new Item("Elixir of the Mongoose", -94, 0)
                },
                {
                    new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                    new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                    new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                    new Item("Sulfuras, Hand of Ragnaros", 0, 80)
                },
                {
                    new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                    new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                    new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                    new Item("Sulfuras, Hand of Ragnaros", -1, 80)
                },
                {
                    new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 13, 22),
                    new Item("Backstage passes to a TAFKAL80ETC concert", -84, 0)
                },
                {
                    new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 9, 50),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 8, 50),
                    new Item("Backstage passes to a TAFKAL80ETC concert", -89, 0)
                },
                {
                    new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50),
                    new Item("Backstage passes to a TAFKAL80ETC concert", -94, 0)
                },
                {
                    // this conjured item does not work properly yet
                    new Item("Conjured Mana Cake", 3, 6),
                    new Item("Conjured Mana Cake", 2, 5),
                    new Item("Conjured Mana Cake", 1, 4),
                    new Item("Conjured Mana Cake", -96, 0)
                }
        });
    }

    @Before
    public void setUp() {
        items = new Item[]{ item };
        gildedRose = new GildedRose();
    }

    @Test
    public void testUpdateQuality_useThreeDaysWorthOfData() {
        List<Item> resultingItems = gildedRose.updateQuality(items);

        assertEquals(firstDay.getName(), resultingItems.get(0).getName());
        assertEquals(firstDay.getSellIn(), resultingItems.get(0).getSellIn());
        assertEquals(firstDay.getQuality(), resultingItems.get(0).getQuality());

        resultingItems = gildedRose.updateQuality(items);

        assertEquals(secondDay.getName(), resultingItems.get(0).getName());
        assertEquals(secondDay.getSellIn(), resultingItems.get(0).getSellIn());
        assertEquals(secondDay.getQuality(), resultingItems.get(0).getQuality());

        // Run same test to reach 99 days
        for (int i = 0; i < 97; i++) {
            resultingItems = gildedRose.updateQuality(items);
        }

        assertEquals(ninetyNineDay.getName(), resultingItems.get(0).getName());
        assertEquals(ninetyNineDay.getSellIn(), resultingItems.get(0).getSellIn());
        assertEquals(ninetyNineDay.getQuality(), resultingItems.get(0).getQuality());
    }

}
