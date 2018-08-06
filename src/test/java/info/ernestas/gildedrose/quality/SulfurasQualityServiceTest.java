package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SulfurasQualityServiceTest {

    private Item correctItem;
    private SulfurasQualityService sulfurasQualityService;

    @Before
    public void setUp() {
        sulfurasQualityService = new SulfurasQualityService();
        correctItem = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
    }

    @Test
    public void testGetQualityServiceName() {
        assertThat(sulfurasQualityService.getQualityServiceName(), is("Sulfuras, Hand of Ragnaros"));
    }

    @Test
    public void testGetQuality() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);

        Item result = sulfurasQualityService.getQuality(item);

        assertThat(result.getName(), is(correctItem.getName()));
        assertThat(result.getQuality(), is(correctItem.getQuality()));
    }

}
