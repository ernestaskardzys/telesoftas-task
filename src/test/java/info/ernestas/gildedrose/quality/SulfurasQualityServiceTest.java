package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;
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
        correctItem = ItemBuilder.item().setName(QualityServiceName.SULFURAS.getName()).setSellIn(0).setQuality(80).build();
    }

    @Test
    public void testGetQualityServiceName() {
        assertThat(sulfurasQualityService.getQualityServiceName(), is(QualityServiceName.SULFURAS.getName()));
    }

    @Test
    public void testGetQuality() {
        Item item = ItemBuilder.item().setName(QualityServiceName.SULFURAS.getName()).setSellIn(0).setQuality(80).build();

        int result = sulfurasQualityService.getQuality(item);

        assertThat(result, is(correctItem.getQuality()));
    }

}
