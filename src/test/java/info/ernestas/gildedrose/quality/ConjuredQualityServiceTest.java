package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;
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
        correctItem = new Item("Conjured Mana Cake", 2, 5);
    }

    @Test
    public void testGetQualityServiceName() {
        assertThat(conjuredQualityService.getQualityServiceName(), is("Conjured Mana Cake"));
    }

    @Test
    public void testGetQuality() {
    }
}
