package info.ernestas.gildedrose.kata;

import info.ernestas.gildedrose.quality.QualityServiceName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GildedRoseTest {

    private GildedRose gildedRose;

    private Item input;
    private Item firstDay;
    private Item secondDay;
    private Item[] items;
    private final Item ninetyNineDay;

    public GildedRoseTest(Item input, Item firstDay, Item secondDay, Item ninetyNineDay) {
        this.input = input;
        this.firstDay = firstDay;
        this.secondDay = secondDay;
        this.ninetyNineDay = ninetyNineDay;
    }

    @Parameterized.Parameters(name = "{index}: updateQuality({0})={1}")
    public static Collection<Item[]> data() {
        return Arrays.asList(new Item[][] {
                {
                    ItemBuilder.item().setName(QualityServiceName.DEXTERITY.getName()).setSellIn(10).setQuality(20).build(),
                    ItemBuilder.item().setName(QualityServiceName.DEXTERITY.getName()).setSellIn(9).setQuality(19).build(),
                    ItemBuilder.item().setName(QualityServiceName.DEXTERITY.getName()).setSellIn(8).setQuality(18).build(),
                    ItemBuilder.item().setName(QualityServiceName.DEXTERITY.getName()).setSellIn(-89).setQuality(0).build()
                },
                {
                    ItemBuilder.item().setName(QualityServiceName.AGED.getName()).setSellIn(2).setQuality(0).build(),
                    ItemBuilder.item().setName(QualityServiceName.AGED.getName()).setSellIn(1).setQuality(1).build(),
                    ItemBuilder.item().setName(QualityServiceName.AGED.getName()).setSellIn(0).setQuality(2).build(),
                    ItemBuilder.item().setName(QualityServiceName.AGED.getName()).setSellIn(-97).setQuality(50).build()
                },
                {
                    ItemBuilder.item().setName(QualityServiceName.ELIXIR.getName()).setSellIn(5).setQuality(7).build(),
                    ItemBuilder.item().setName(QualityServiceName.ELIXIR.getName()).setSellIn(4).setQuality(6).build(),
                    ItemBuilder.item().setName(QualityServiceName.ELIXIR.getName()).setSellIn(3).setQuality(5).build(),
                    ItemBuilder.item().setName(QualityServiceName.ELIXIR.getName()).setSellIn(-94).setQuality(0).build()
                },
                {
                    ItemBuilder.item().setName(QualityServiceName.SULFURAS.getName()).setSellIn(0).setQuality(80).build(),
                    ItemBuilder.item().setName(QualityServiceName.SULFURAS.getName()).setSellIn(0).setQuality(80).build(),
                    ItemBuilder.item().setName(QualityServiceName.SULFURAS.getName()).setSellIn(0).setQuality(80).build(),
                    ItemBuilder.item().setName(QualityServiceName.SULFURAS.getName()).setSellIn(0).setQuality(80).build()
                },
                {
                    ItemBuilder.item().setName(QualityServiceName.SULFURAS.getName()).setSellIn(-1).setQuality(80).build(),
                    ItemBuilder.item().setName(QualityServiceName.SULFURAS.getName()).setSellIn(-1).setQuality(80).build(),
                    ItemBuilder.item().setName(QualityServiceName.SULFURAS.getName()).setSellIn(-1).setQuality(80).build(),
                    ItemBuilder.item().setName(QualityServiceName.SULFURAS.getName()).setSellIn(-1).setQuality(80).build()
                },
                {
                    ItemBuilder.item().setName(QualityServiceName.TAFKAL.getName()).setSellIn(15).setQuality(20).build(),
                    ItemBuilder.item().setName(QualityServiceName.TAFKAL.getName()).setSellIn(14).setQuality(21).build(),
                    ItemBuilder.item().setName(QualityServiceName.TAFKAL.getName()).setSellIn(13).setQuality(22).build(),
                    ItemBuilder.item().setName(QualityServiceName.TAFKAL.getName()).setSellIn(-84).setQuality(0).build()
                },
                {
                    ItemBuilder.item().setName(QualityServiceName.TAFKAL.getName()).setSellIn(10).setQuality(49).build(),
                    ItemBuilder.item().setName(QualityServiceName.TAFKAL.getName()).setSellIn(9).setQuality(50).build(),
                    ItemBuilder.item().setName(QualityServiceName.TAFKAL.getName()).setSellIn(8).setQuality(50).build(),
                    ItemBuilder.item().setName(QualityServiceName.TAFKAL.getName()).setSellIn(-89).setQuality(0).build()
                },
                {
                    ItemBuilder.item().setName(QualityServiceName.TAFKAL.getName()).setSellIn(5).setQuality(49).build(),
                    ItemBuilder.item().setName(QualityServiceName.TAFKAL.getName()).setSellIn(4).setQuality(50).build(),
                    ItemBuilder.item().setName(QualityServiceName.TAFKAL.getName()).setSellIn(3).setQuality(50).build(),
                    ItemBuilder.item().setName(QualityServiceName.TAFKAL.getName()).setSellIn(-94).setQuality(0).build()
                },
                {
                    // this conjured item does not work properly yet
                    ItemBuilder.item().setName(QualityServiceName.CONJURED.getName()).setSellIn(3).setQuality(6).build(),
                    ItemBuilder.item().setName(QualityServiceName.CONJURED.getName()).setSellIn(2).setQuality(5).build(),
                    ItemBuilder.item().setName(QualityServiceName.CONJURED.getName()).setSellIn(1).setQuality(4).build(),
                    ItemBuilder.item().setName(QualityServiceName.CONJURED.getName()).setSellIn(-96).setQuality(0).build()
                }
        });
    }

    @Before
    public void setUp() {
        items = new Item[]{ input };
        gildedRose = new GildedRose();
    }

    @Test
    public void testUpdateQuality_useThreeDaysWorthOfData() {
        List<Item> resultingItems = gildedRose.updateQuality(items);

        assertEquals(firstDay.getName(), resultingItems.get(0).getName());
        assertEquals(firstDay.getSellIn(), resultingItems.get(0).getSellIn());
        assertEquals(firstDay.getQuality(), resultingItems.get(0).getQuality());

        final Function<Item, Item> createItem = item -> new Item(UUID.randomUUID(), item.getName(), item.getSellIn(), item.getQuality());

        resultingItems = gildedRose.updateQuality(resultingItems.stream().map(createItem).toArray(Item[]::new));

        assertEquals(secondDay.getName(), resultingItems.get(0).getName());
        assertEquals(secondDay.getSellIn(), resultingItems.get(0).getSellIn());
        assertEquals(secondDay.getQuality(), resultingItems.get(0).getQuality());

        // Run same test to reach 99 days
        for (int i = 0; i < 97; i++) {
            resultingItems = gildedRose.updateQuality(resultingItems.stream().map(createItem).toArray(Item[]::new));
        }

        assertEquals(ninetyNineDay.getName(), resultingItems.get(0).getName());
        assertEquals(ninetyNineDay.getSellIn(), resultingItems.get(0).getSellIn());
        assertEquals(ninetyNineDay.getQuality(), resultingItems.get(0).getQuality());
    }

}
