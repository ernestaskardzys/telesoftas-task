package info.ernestas.gildedrose.kata;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ItemBuilderTest {

    private ItemBuilder itemBuilder;

    @Before
    public void setUp() {
        itemBuilder = new ItemBuilder().setName("Test name").setQuality(1).setSellIn(2);
    }

    @Test
    public void testSetName() {
        assertThat(itemBuilder.build().getName(), is("Test name"));
    }

    @Test
    public void testSetSellIn() {
        assertThat(itemBuilder.build().getSellIn(), is(2));
    }

    @Test
    public void testSetQuality() {
        assertThat(itemBuilder.build().getQuality(), is(1));
    }

}
