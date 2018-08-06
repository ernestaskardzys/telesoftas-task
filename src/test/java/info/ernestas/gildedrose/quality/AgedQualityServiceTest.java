package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AgedQualityServiceTest {

    private Item correctItem;
    private AgedQualityService agedQualityService;

    @Before
    public void setUp() {
        agedQualityService = new AgedQualityService();
        correctItem = new Item("Aged Brie", 1, 1);
    }

    @Test
    public void testGetQualityServiceName() {
        assertThat(agedQualityService.getQualityServiceName(), is("Aged Brie"));
    }

    @Test
    public void testGetQuality() {
    }
}
