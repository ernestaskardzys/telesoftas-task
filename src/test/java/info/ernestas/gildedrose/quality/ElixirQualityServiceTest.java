package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ElixirQualityServiceTest {

    private static final String NAME = "Elixir of the Mongoose";

    private Item correctItem;
    private ElixirQualityService elixirQualityService;

    @Before
    public void setUp() {
        elixirQualityService = new ElixirQualityService();
        correctItem = ItemBuilder.item().setName(NAME).setSellIn(4).setQuality(6).build();
    }

    @Test
    public void testGetQualityServiceName() {
        assertThat(elixirQualityService.getQualityServiceName(), is(NAME));
    }

    @Test
    public void testGetQuality() {
        Item item = ItemBuilder.item().setName(NAME).setSellIn(5).setQuality(7).build();

        int result = elixirQualityService.getQuality(item);

        assertThat(result, is(correctItem.getQuality()));
    }
}
