package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DexterityQualityServiceTest {

    private static final String NAME = "+5 Dexterity Vest";

    private Item correctItem;
    private DexterityQualityService dexterityQualityService;

    @Before
    public void setUp() {
        dexterityQualityService = new DexterityQualityService();
        correctItem = ItemBuilder.item().setName(NAME).setSellIn(9).setQuality(19).build();
    }

    @Test
    public void testGetQualityServiceName() {
        assertThat(dexterityQualityService.getQualityServiceName(), is(NAME));
    }

    @Test
    public void testGetQuality() {
        Item item = ItemBuilder.item().setName(NAME).setSellIn(10).setQuality(20).build();

        int result = dexterityQualityService.getQuality(item);

        assertThat(result, is(correctItem.getQuality()));
    }

}
