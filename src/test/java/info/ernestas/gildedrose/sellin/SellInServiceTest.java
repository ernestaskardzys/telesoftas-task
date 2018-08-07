package info.ernestas.gildedrose.sellin;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;
import info.ernestas.gildedrose.quality.QualityServiceName;
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
        Item item = ItemBuilder.item().setName(QualityServiceName.CONJURED.getName()).setSellIn(3).setQuality(6).build();

        int result = sellInService.getSellIn(item.getName(), item.getSellIn());

        assertThat(result, is(2));
    }

    @Test
    public void testGetSellIn_forSulfurasConcert_shouldNotDecreaseSellIn() {
        Item item = ItemBuilder.item().setName(QualityServiceName.SULFURAS.getName()).setSellIn(0).setQuality(80).build();

        int result = sellInService.getSellIn(item.getName(), item.getSellIn());

        assertThat(result, is(0));
    }

}
