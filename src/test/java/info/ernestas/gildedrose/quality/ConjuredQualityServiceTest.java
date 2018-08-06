package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConjuredQualityServiceTest {

    private static final String NAME = "Conjured Mana Cake";

    private Item correctItem;
    private ConjuredQualityService conjuredQualityService;

    @Before
    public void setUp() {
        conjuredQualityService = new ConjuredQualityService();
        correctItem = ItemBuilder.item().setName(NAME).setSellIn(2).setQuality(5).build();
    }

    @Test
    public void testGetQualityServiceName() {
        assertThat(conjuredQualityService.getQualityServiceName(), is(NAME));
    }

    @Test
    public void testGetQuality() {
        Item item = ItemBuilder.item().setName(NAME).setSellIn(3).setQuality(6).build();

        Item result = conjuredQualityService.getQuality(item);

        assertThat(result.getName(), is(correctItem.getName()));
        assertThat(result.getQuality(), is(correctItem.getQuality()));
    }
}
