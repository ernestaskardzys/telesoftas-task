package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ElixirQualityServiceTest {

    private Item correctItem;
    private ElixirQualityService elixirQualityService;

    @Before
    public void setUp() {
        elixirQualityService = new ElixirQualityService();
        correctItem = new ItemBuilder().setName("Elixir of the Mongoose").setSellIn(4).setQuality(6).build();
    }

    @Test
    public void testGetQualityServiceName() {
        assertThat(elixirQualityService.getQualityServiceName(), is("Elixir of the Mongoose"));
    }

    @Test
    public void testGetQuality() {
        Item item = new ItemBuilder().setName("Elixir of the Mongoose").setSellIn(5).setQuality(7).build();

        Item result = elixirQualityService.getQuality(item);

        assertThat(result.getName(), is(correctItem.getName()));
        assertThat(result.getQuality(), is(correctItem.getQuality()));
    }
}
