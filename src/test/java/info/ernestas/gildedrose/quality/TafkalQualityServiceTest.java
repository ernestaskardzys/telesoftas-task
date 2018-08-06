package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TafkalQualityServiceTest {

    private static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    private Item correctItem;
    private TafkalQualityService tafkalQualityService;

    @Before
    public void setUp() {
        tafkalQualityService = new TafkalQualityService();
        correctItem = ItemBuilder.item().setName(NAME).setSellIn(14).setQuality(21).build();
    }

    @Test
    public void testGetQualityServiceName() {
        assertThat(tafkalQualityService.getQualityServiceName(), is(NAME));
    }

    @Test
    public void testGetQuality() {
        Item item = ItemBuilder.item().setName(NAME).setSellIn(15).setQuality(20).build();

        int result = tafkalQualityService.getQuality(item);

        assertThat(result, is(correctItem.getQuality()));
    }

}
