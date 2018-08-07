package info.ernestas.gildedrose.service.transformer;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;
import info.ernestas.gildedrose.model.entity.ItemEntity;
import info.ernestas.gildedrose.quality.QualityServiceName;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ItemToItemEntityTransformerTest {

    private UUID id;
    private ItemToItemEntityTransformer transformer;

    @Before
    public void setUp() {
        id = UUID.randomUUID();
        transformer = new ItemToItemEntityTransformer();
    }

    @Test
    public void testConvertToItemEntity() {
        Item item = ItemBuilder.item().setId(id).setName(QualityServiceName.AGED.getName()).setSellIn(2).setQuality(0).build();

        ItemEntity itemEntity = transformer.convertToItemEntity(item);

        assertThat(itemEntity.getId(), is(notNullValue()));
        assertThat(itemEntity.getName(), is(item.getName()));
        assertThat(itemEntity.getSellIn(), is(item.getSellIn()));
        assertThat(itemEntity.getQuality(), is(item.getQuality()));
    }

    @Test
    public void testConvertToItem() {
        ItemEntity itemEntity = new ItemEntity(id, QualityServiceName.AGED.getName(), 2, 0);

        Item item = transformer.convertToItem(itemEntity);

        assertThat(item.getName(), is(itemEntity.getName()));
        assertThat(item.getSellIn(), is(itemEntity.getSellIn()));
        assertThat(item.getQuality(), is(itemEntity.getQuality()));
    }

}
