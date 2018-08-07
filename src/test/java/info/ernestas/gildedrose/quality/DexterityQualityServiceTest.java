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
        correctItem = ItemBuilder.item().setName(QualityServiceName.DEXTERITY.getName()).setSellIn(9).setQuality(19).build();
    }

    @Test
    public void testGetQualityServiceName() {
        assertThat(dexterityQualityService.getQualityServiceName(), is(QualityServiceName.DEXTERITY.getName()));
    }

    @Test
    public void testGetQuality() {
        Item item = ItemBuilder.item().setName(QualityServiceName.DEXTERITY.getName()).setSellIn(10).setQuality(20).build();

        int result = dexterityQualityService.getQuality(item);

        assertThat(result, is(correctItem.getQuality()));
    }

}
