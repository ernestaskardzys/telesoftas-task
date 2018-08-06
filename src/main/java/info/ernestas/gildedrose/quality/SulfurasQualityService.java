package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;

public class SulfurasQualityService extends QualityService {

    @Override
    public String getQualityServiceName() {
        return "Sulfuras, Hand of Ragnaros";
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
