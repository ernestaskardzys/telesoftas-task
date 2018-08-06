package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DexterityQualityServiceTest {

    private Item correctItem;
    private DexterityQualityService dexterityQualityService;

    @Before
    public void setUp() {
        dexterityQualityService = new DexterityQualityService();
        correctItem = ItemBuilder.item().setName("+5 Dexterity Vest").setSellIn(9).setQuality(19).build();
    }

    @Test
    public void testGetQualityServiceName() {
        assertThat(dexterityQualityService.getQualityServiceName(), is("+5 Dexterity Vest"));
    }

    @Test
    public void testGetQuality() {
        Item item = ItemBuilder.item().setName("+5 Dexterity Vest").setSellIn(10).setQuality(20).build();

        Item result = dexterityQualityService.getQuality(item);

        assertThat(result.getName(), is(correctItem.getName()));
        assertThat(result.getQuality(), is(correctItem.getQuality()));
    }

}
