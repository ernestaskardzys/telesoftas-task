package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;

public class ElixirQualityService extends QualityService {

    @Override
    public String getQualityServiceName() {
        return "Elixir of the Mongoose";
    }

    @Override
    public Item getQuality(Item item) {
        int quality = decreaseQualityExceptForSulfurasConcert(item.getName(), item.getQuality());

        if (item.getSellIn() < 0) {
            quality = decreaseQualityExceptForSulfurasConcert(item.getName(), quality);
        }

        return ItemBuilder.item().clone(item).setQuality(quality).build();
    }

}
