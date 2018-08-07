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
        correctItem = ItemBuilder.item().setName(QualityServiceName.TAFKAL.getName()).setSellIn(14).setQuality(21).build();
    }

    @Test
    public void testGetQualityServiceName() {
        assertThat(tafkalQualityService.getQualityServiceName(), is(QualityServiceName.TAFKAL.getName()));
    }

    @Test
    public void testGetQuality() {
        Item item = ItemBuilder.item().setName(QualityServiceName.TAFKAL.getName()).setSellIn(15).setQuality(20).build();

        int result = tafkalQualityService.getQuality(item);

        assertThat(result, is(correctItem.getQuality()));
    }

}
