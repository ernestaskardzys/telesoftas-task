package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;
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
        correctItem = new Item("Elixir of the Mongoose", 4, 6);
    }

    @Test
    public void testGetQualityServiceName() {
        assertThat(elixirQualityService.getQualityServiceName(), is("Elixir of the Mongoose"));
    }

    @Test
    public void testGetQuality() {
        Item item = new Item("Elixir of the Mongoose", 5, 7);

        Item result = elixirQualityService.getQuality(item);

        assertThat(result.getName(), is(correctItem.getName()));
        assertThat(result.getQuality(), is(correctItem.getQuality()));
    }
}
