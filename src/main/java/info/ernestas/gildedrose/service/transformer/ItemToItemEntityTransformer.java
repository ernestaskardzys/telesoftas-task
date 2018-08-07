package info.ernestas.gildedrose.service.transformer;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.model.entity.ItemEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ItemToItemEntityTransformer {

    public ItemEntity convert(Item item) {
        return new ItemEntity(UUID.randomUUID(), item.getName(), item.getSellIn(), item.getQuality());
    }

}
