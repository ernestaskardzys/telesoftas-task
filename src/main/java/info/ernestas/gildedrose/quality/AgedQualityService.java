package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;

public class AgedQualityService extends QualityService {

    @Override
    public String getQualityServiceName() {
        return "Aged Brie";
    }

    @Override
    public Item getQuality(Item item) {
        increaseQualityIfQualityLessThanFifty(item);

        if (item.getSellIn() < 0) {
            increaseQualityIfQualityLessThanFifty(item);
        }

        return item;
    }

}
