package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TafkalQualityServiceTest {

    private Item correctItem;
    private TafkalQualityService tafkalQualityService;

    @Before
    public void setUp() {
        tafkalQualityService = new TafkalQualityService();
        correctItem = ItemBuilder.item().setName("Backstage passes to a TAFKAL80ETC concert").setSellIn(14).setQuality(21).build();
    }

    @Test
    public void testGetQualityServiceName() {
        assertThat(tafkalQualityService.getQualityServiceName(), is("Backstage passes to a TAFKAL80ETC concert"));
    }

    @Test
    public void testGetQuality() {
        Item item = ItemBuilder.item().setName("Backstage passes to a TAFKAL80ETC concert").setSellIn(15).setQuality(20).build();

        Item result = tafkalQualityService.getQuality(item);

        assertThat(result.getName(), is(correctItem.getName()));
        assertThat(result.getQuality(), is(correctItem.getQuality()));
    }

}
