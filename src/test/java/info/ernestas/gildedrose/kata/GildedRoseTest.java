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
                    new ItemBuilder().setName("+5 Dexterity Vest").setSellIn(10).setQuality(20).build(),
                    new ItemBuilder().setName("+5 Dexterity Vest").setSellIn(9).setQuality(19).build(),
                    new ItemBuilder().setName("+5 Dexterity Vest").setSellIn(8).setQuality(18).build(),
                    new ItemBuilder().setName("+5 Dexterity Vest").setSellIn(-89).setQuality(0).build()
                },
                {
                    new ItemBuilder().setName("Aged Brie").setSellIn(2).setQuality(0).build(),
                    new ItemBuilder().setName("Aged Brie").setSellIn(1).setQuality(1).build(),
                    new ItemBuilder().setName("Aged Brie").setSellIn(0).setQuality(2).build(),
                    new ItemBuilder().setName("Aged Brie").setSellIn(-97).setQuality(50).build()
                },
                {
                    new ItemBuilder().setName("Elixir of the Mongoose").setSellIn(5).setQuality(7).build(),
                    new ItemBuilder().setName("Elixir of the Mongoose").setSellIn(4).setQuality(6).build(),
                    new ItemBuilder().setName("Elixir of the Mongoose").setSellIn(3).setQuality(5).build(),
                    new ItemBuilder().setName("Elixir of the Mongoose").setSellIn(-94).setQuality(0).build()
                },
                {
                    new ItemBuilder().setName("Sulfuras, Hand of Ragnaros").setSellIn(0).setQuality(80).build(),
                    new ItemBuilder().setName("Sulfuras, Hand of Ragnaros").setSellIn(0).setQuality(80).build(),
                    new ItemBuilder().setName("Sulfuras, Hand of Ragnaros").setSellIn(0).setQuality(80).build(),
                    new ItemBuilder().setName("Sulfuras, Hand of Ragnaros").setSellIn(0).setQuality(80).build()
                },
                {
                    new ItemBuilder().setName("Sulfuras, Hand of Ragnaros").setSellIn(-1).setQuality(80).build(),
                    new ItemBuilder().setName("Sulfuras, Hand of Ragnaros").setSellIn(-1).setQuality(80).build(),
                    new ItemBuilder().setName("Sulfuras, Hand of Ragnaros").setSellIn(-1).setQuality(80).build(),
                    new ItemBuilder().setName("Sulfuras, Hand of Ragnaros").setSellIn(-1).setQuality(80).build()
                },
                {
                    new ItemBuilder().setName("Backstage passes to a TAFKAL80ETC concert").setSellIn(15).setQuality(20).build(),
                    new ItemBuilder().setName("Backstage passes to a TAFKAL80ETC concert").setSellIn(14).setQuality(21).build(),
                    new ItemBuilder().setName("Backstage passes to a TAFKAL80ETC concert").setSellIn(13).setQuality(22).build(),
                    new ItemBuilder().setName("Backstage passes to a TAFKAL80ETC concert").setSellIn(-84).setQuality(0).build()
                },
                {
                    new ItemBuilder().setName("Backstage passes to a TAFKAL80ETC concert").setSellIn(10).setQuality(49).build(),
                    new ItemBuilder().setName("Backstage passes to a TAFKAL80ETC concert").setSellIn(9).setQuality(50).build(),
                    new ItemBuilder().setName("Backstage passes to a TAFKAL80ETC concert").setSellIn(8).setQuality(50).build(),
                    new ItemBuilder().setName("Backstage passes to a TAFKAL80ETC concert").setSellIn(-89).setQuality(0).build()
                },
                {
                    new ItemBuilder().setName("Backstage passes to a TAFKAL80ETC concert").setSellIn(5).setQuality(49).build(),
                    new ItemBuilder().setName("Backstage passes to a TAFKAL80ETC concert").setSellIn(4).setQuality(50).build(),
                    new ItemBuilder().setName("Backstage passes to a TAFKAL80ETC concert").setSellIn(3).setQuality(50).build(),
                    new ItemBuilder().setName("Backstage passes to a TAFKAL80ETC concert").setSellIn(-94).setQuality(0).build()
                },
                {
                    // this conjured item does not work properly yet
                    new ItemBuilder().setName("Conjured Mana Cake").setSellIn(3).setQuality(6).build(),
                    new ItemBuilder().setName("Conjured Mana Cake").setSellIn(2).setQuality(5).build(),
                    new ItemBuilder().setName("Conjured Mana Cake").setSellIn(1).setQuality(4).build(),
                    new ItemBuilder().setName("Conjured Mana Cake").setSellIn(-96).setQuality(0).build()
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
