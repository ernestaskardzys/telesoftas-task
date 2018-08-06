package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;

public class ElixirQualityService extends QualityService {

    @Override
    public String getQualityServiceName() {
        return "Elixir of the Mongoose";
    }

    @Override
    public Item getQuality(Item item) {
        decreaseQualityExceptForSulfurasConcert(item);

        if (item.getSellIn() < 0) {
            decreaseQualityExceptForSulfurasConcert(item);
        }

        return item;
    }

}
