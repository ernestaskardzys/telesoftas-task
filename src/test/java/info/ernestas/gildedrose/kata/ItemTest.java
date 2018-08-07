package info.ernestas.gildedrose.kata;

import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ItemTest {

    private static final String NAME = "First item";
    private static final UUID ID = UUID.randomUUID();
    private static final int SELL_IN = 10;
    private static final int QUALITY = 11;
    private static final String SEPARATOR = ", ";

    private Item item;

    @Before
    public void setUp() {
        item = ItemBuilder.item().setId(ID).setName(NAME).setSellIn(SELL_IN).setQuality(QUALITY).build();
    }

    @Test
    public void testGetId() {
        assertThat(item.getId(), is(ID));
    }

    @Test
    public void testGetName() {
        assertThat(item.getName(), is(NAME));
    }

    @Test
    public void testGetSellIn() {
        assertThat(item.getSellIn(), is(SELL_IN));
    }

    @Test
    public void testGetQuantity() {
        assertThat(item.getQuality(), is(QUALITY));
    }

    @Test
    public void testToString() {
        String result = item.toString();

        assertThat(result, is(ID + SEPARATOR + NAME + SEPARATOR + SELL_IN + SEPARATOR + QUALITY));
    }
}
