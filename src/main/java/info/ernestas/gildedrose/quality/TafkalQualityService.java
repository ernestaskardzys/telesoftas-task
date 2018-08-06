package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;

public class TafkalQualityService extends QualityService {

    @Override
    public String getQualityServiceName() {
        return "Backstage passes to a TAFKAL80ETC concert";
    }

    @Override
    public Item getQuality(Item item) {
        increaseQualityIfQualityLessThanFifty(item);

        if (item.getSellIn() < 11) {
            increaseQualityIfQualityLessThanFifty(item);
        }

        if (item.getSellIn() < 6) {
            increaseQualityIfQualityLessThanFifty(item);
        }

        if (item.getSellIn() < 0) {
            item.setQuality(0);

            decreaseQualityExceptForSulfurasConcert(item);
        }

        return item;
    }
}
