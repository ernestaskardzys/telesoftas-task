package info.ernestas.gildedrose.service.transformer;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.model.entity.ItemEntity;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class ItemToItemEntityTransformer {

    public List<ItemEntity> convertToItemEntities(List<Item> items) {
        return items.stream().map(i -> convertToItemEntity(i)).collect(toList());
    }

    public List<Item> convertToItems(List<ItemEntity> itemEntities) {
        return itemEntities.stream().map(e -> convertToItem(e)).collect(toList());
    }

    private ItemEntity convertToItemEntity(Item item) {
        return new ItemEntity(item.getId(), item.getName(), item.getSellIn(), item.getQuality());
    }

    private Item convertToItem(ItemEntity itemEntity) {
        return new Item(itemEntity.getId(), itemEntity.getName(), itemEntity.getSellIn(), itemEntity.getQuality());
    }

}
