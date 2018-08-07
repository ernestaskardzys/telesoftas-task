package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DefaultQualityServiceTest {

    private Item correctItem;
    private DefaultQualityService defaultQualityService;

    @Before
    public void setUp() {
        defaultQualityService = new DefaultQualityService();
        correctItem = ItemBuilder.item().setName(QualityServiceName.DEFAULT.getName()).setSellIn(2).setQuality(5).build();
    }

    @Test
    public void testGetQualityServiceName() {
        assertThat(defaultQualityService.getQualityServiceName(), is(QualityServiceName.DEFAULT.getName()));
    }

    @Test
    public void testGetQuality() {
        Item item = ItemBuilder.item().setName(QualityServiceName.DEFAULT.getName()).setSellIn(3).setQuality(6).build();

        int result = defaultQualityService.getQuality(item);

        assertThat(result, is(correctItem.getQuality()));
    }

}
