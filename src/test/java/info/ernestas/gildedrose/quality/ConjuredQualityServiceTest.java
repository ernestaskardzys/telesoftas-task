package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConjuredQualityServiceTest {

    private Item correctItem;
    private ConjuredQualityService conjuredQualityService;

    @Before
    public void setUp() {
        conjuredQualityService = new ConjuredQualityService();
        correctItem = ItemBuilder.item().setName(QualityServiceName.CONJURED.getName()).setSellIn(2).setQuality(5).build();
    }

    @Test
    public void testGetQualityServiceName() {
        assertThat(conjuredQualityService.getQualityServiceName(), is(QualityServiceName.CONJURED.getName()));
    }

    @Test
    public void testGetQuality() {
        Item item = ItemBuilder.item().setName(QualityServiceName.CONJURED.getName()).setSellIn(3).setQuality(6).build();

        int result = conjuredQualityService.getQuality(item);

        assertThat(result, is(correctItem.getQuality()));
    }
}
