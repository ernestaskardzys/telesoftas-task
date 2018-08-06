package info.ernestas.gildedrose.sellin;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SellInServiceTest {

    private SellInService sellInService;

    @Before
    public void setUp() {
        sellInService = new SellInService();
    }

    @Test
    public void testGetSellIn() {
        Item item = ItemBuilder.item().setName("Conjured Mana Cake").setSellIn(3).setQuality(6).build();

        Item result = sellInService.getSellIn(item);

        assertThat(result.getSellIn(), is(2));
    }

    @Test
    public void testGetSellIn_forSulfurasConcert_shouldNotDecreaseSellIn() {
        Item item = ItemBuilder.item().setName("Sulfuras, Hand of Ragnaros").setSellIn(0).setQuality(80).build();

        Item result = sellInService.getSellIn(item);

        assertThat(result.getSellIn(), is(0));
    }

}
