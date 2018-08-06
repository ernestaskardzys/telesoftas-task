package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AgedQualityServiceTest {

    private Item correctItem;
    private AgedQualityService agedQualityService;

    @Before
    public void setUp() {
        agedQualityService = new AgedQualityService();
        correctItem = ItemBuilder.item().setName("Aged Brie").setSellIn(1).setQuality(1).build();
    }

    @Test
    public void testGetQualityServiceName() {
        assertThat(agedQualityService.getQualityServiceName(), is("Aged Brie"));
    }

    @Test
    public void testGetQuality() {
        Item item = ItemBuilder.item().setName("Aged Brie").setSellIn(2).setQuality(0).build();

        Item result = agedQualityService.getQuality(item);

        assertThat(result.getName(), is(correctItem.getName()));
        assertThat(result.getQuality(), is(correctItem.getQuality()));
    }

}
