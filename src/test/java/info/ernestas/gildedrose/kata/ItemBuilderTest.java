package info.ernestas.gildedrose.kata;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ItemBuilderTest {

    private static final String NAME = "Test name";
    private static final int QUALITY = 1;
    private static final int SELL_IN = 2;

    private ItemBuilder itemBuilder;

    @Before
    public void setUp() {
        itemBuilder = ItemBuilder.item().setName(NAME).setSellIn(SELL_IN).setQuality(QUALITY);
    }

    @Test
    public void testSetName() {
        assertThat(itemBuilder.build().getName(), is(NAME));
    }

    @Test
    public void testSetSellIn() {
        assertThat(itemBuilder.build().getSellIn(), is(SELL_IN));
    }

    @Test
    public void testSetQuality() {
        assertThat(itemBuilder.build().getQuality(), is(QUALITY));
    }

    @Test
    public void testClone() {
        Item item = itemBuilder.build();

        Item clonedItem = ItemBuilder.item().clone(item).build();

        assertThat(clonedItem, is(item));
    }
}
