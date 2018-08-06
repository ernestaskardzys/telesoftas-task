package info.ernestas.gildedrose.kata;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ItemTest {

    private static final String NAME = "First item";
    private static final int SELL_IN = 10;
    private static final int QUALITY = 11;

    private Item item;

    @Before
    public void setUp() {
        item = new Item(NAME, SELL_IN, QUALITY);
    }

    @Test
    public void testGetName() {
        assertThat(item.name, is(NAME));
    }

    @Test
    public void testGetSellIn() {
        assertThat(item.sellIn, is(SELL_IN));
    }

    @Test
    public void testGetQuantity() {
        assertThat(item.quality, is(QUALITY));
    }

    @Test
    public void testToString() {
        String result = item.toString();

        assertThat(result, is(NAME + ", " + SELL_IN + ", " + QUALITY));
    }
}
