package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;
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
        correctItem = new Item("+5 Dexterity Vest", 9, 19);
    }

    @Test
    public void testGetQualityServiceName() {
        assertThat(dexterityQualityService.getQualityServiceName(), is("+5 Dexterity Vest"));
    }

    @Test
    public void testGetQuality() {
        Item item = new Item("+5 Dexterity Vest", 10, 20);

        Item result = dexterityQualityService.getQuality(item);

        assertThat(result.getName(), is(correctItem.getName()));
        assertThat(result.getQuality(), is(correctItem.getQuality()));
    }

}
