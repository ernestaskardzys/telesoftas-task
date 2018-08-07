package info.ernestas.gildedrose.services.transformer;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;
import info.ernestas.gildedrose.model.entity.ItemEntity;
import info.ernestas.gildedrose.quality.QualityServiceName;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ItemToItemEntityTransformerTest {

    private ItemToItemEntityTransformer transformer;

    @Before
    public void setUp() {
        transformer = new ItemToItemEntityTransformer();
    }

    @Test
    public void testItemToItemEntity() {
        Item item = ItemBuilder.item().setName(QualityServiceName.AGED.getName()).setSellIn(2).setQuality(0).build();

        ItemEntity itemEntity = transformer.convert(item);

        assertThat(itemEntity.getId(), is(notNullValue()));
        assertThat(itemEntity.getName(), is(item.getName()));
        assertThat(itemEntity.getSellIn(), is(item.getSellIn()));
        assertThat(itemEntity.getQuality(), is(item.getQuality()));
    }
}
