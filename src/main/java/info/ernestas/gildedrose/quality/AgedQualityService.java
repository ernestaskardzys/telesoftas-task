package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;

public class AgedQualityService extends QualityService {

    @Override
    public String getQualityServiceName() {
        return "Aged Brie";
    }

    @Override
    public Item getQuality(Item item) {
        int quality = increaseQualityIfQualityLessThanFifty(item.getQuality());

        if (item.getSellIn() < 0) {
            quality = increaseQualityIfQualityLessThanFifty(quality);
        }

        return new Item(item.getName(), item.getSellIn(), quality);
    }

}
