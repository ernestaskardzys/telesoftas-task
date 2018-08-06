package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;
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
        correctItem = new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21);
    }

    @Test
    public void testGetQualityServiceName() {
        assertThat(tafkalQualityService.getQualityServiceName(), is("Backstage passes to a TAFKAL80ETC concert"));
    }

    @Test
    public void testGetQuality() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);

        Item result = tafkalQualityService.getQuality(item);

        assertThat(result.getName(), is(correctItem.getName()));
        assertThat(result.getQuality(), is(correctItem.getQuality()));
    }

}
