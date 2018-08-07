package info.ernestas.gildedrose;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;
import info.ernestas.gildedrose.kata.RoseWorker;
import info.ernestas.gildedrose.quality.QualityServiceName;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RoseWorkerTest {

    private RoseWorker roseWorker;

    @Before
    public void setUp() {
        roseWorker = new RoseWorker();
    }

    @Test
    public void testGetItem() {
        Item input = ItemBuilder.item().setName(QualityServiceName.CONJURED.getName()).setSellIn(3).setQuality(6).build();
        Item actual = ItemBuilder.item().setName(QualityServiceName.CONJURED.getName()).setSellIn(2).setQuality(5).build();

        Item result = roseWorker.getItem(input);

        assertThat(result.getName(), is(actual.getName()));
        assertThat(result.getSellIn(), is(actual.getSellIn()));
        assertThat(result.getQuality(), is(actual.getQuality()));
    }
}
