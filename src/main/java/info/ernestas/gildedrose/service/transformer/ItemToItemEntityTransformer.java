package info.ernestas.gildedrose.service.transformer;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.model.entity.ItemEntity;
import org.springframework.stereotype.Component;

@Component
public class ItemToItemEntityTransformer {

    public ItemEntity convertToItemEntity(Item item) {
        return new ItemEntity(item.getId(), item.getName(), item.getSellIn(), item.getQuality());
    }

    public Item convertToItem(ItemEntity itemEntity) {
        return new Item(itemEntity.getId(), itemEntity.getName(), itemEntity.getSellIn(), itemEntity.getQuality());
    }

}
