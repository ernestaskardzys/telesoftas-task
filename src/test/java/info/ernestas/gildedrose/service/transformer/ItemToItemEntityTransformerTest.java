package info.ernestas.gildedrose.service.transformer;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;
import info.ernestas.gildedrose.model.entity.ItemEntity;
import info.ernestas.gildedrose.quality.QualityServiceName;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ItemToItemEntityTransformerTest {

    private UUID id;
    private UUID id2;
    private ItemToItemEntityTransformer transformer;

    @Before
    public void setUp() {
        id = UUID.randomUUID();
        id2 = UUID.randomUUID();
        transformer = new ItemToItemEntityTransformer();
    }

    @Test
    public void testConvertToItemEntities() {
        Item item = ItemBuilder.item().setId(id).setName(QualityServiceName.AGED.getName()).setSellIn(2).setQuality(0).build();
        Item item2 = ItemBuilder.item().setId(id2).setName(QualityServiceName.AGED.getName()).setSellIn(2).setQuality(0).build();
        List<Item> items = Arrays.asList(item, item2);

        List<ItemEntity> itemEntities = transformer.convertToItemEntities(items);

        assertThat(items.size(), is(items.size()));
        assertThat(itemEntities.get(0).getId(), is(id));
        assertThat(itemEntities.get(0).getName(), is(item.getName()));
        assertThat(itemEntities.get(0).getSellIn(), is(item.getSellIn()));
        assertThat(itemEntities.get(0).getQuality(), is(item.getQuality()));
        assertThat(itemEntities.get(1).getId(), is(id2));
        assertThat(itemEntities.get(1).getName(), is(item2.getName()));
        assertThat(itemEntities.get(1).getSellIn(), is(item2.getSellIn()));
        assertThat(itemEntities.get(1).getQuality(), is(item2.getQuality()));
    }

    @Test
    public void testConvertToItems() {
        ItemEntity itemEntity = new ItemEntity(id, QualityServiceName.AGED.getName(), 2, 0);
        ItemEntity itemEntity2 = new ItemEntity(id2, QualityServiceName.DEXTERITY.getName(), 2, 0);
        List<ItemEntity> itemEntities = Arrays.asList(itemEntity, itemEntity2);

        List<Item> items = transformer.convertToItems(itemEntities);

        assertThat(items.size(), is(itemEntities.size()));
        assertThat(items.get(0).getId(), is(itemEntity.getId()));
        assertThat(items.get(0).getName(), is(itemEntity.getName()));
        assertThat(items.get(0).getSellIn(), is(itemEntity.getSellIn()));
        assertThat(items.get(0).getQuality(), is(itemEntity.getQuality()));
        assertThat(items.get(1).getId(), is(itemEntity2.getId()));
        assertThat(items.get(1).getName(), is(itemEntity2.getName()));
        assertThat(items.get(1).getSellIn(), is(itemEntity2.getSellIn()));
        assertThat(items.get(1).getQuality(), is(itemEntity2.getQuality()));
    }

}
