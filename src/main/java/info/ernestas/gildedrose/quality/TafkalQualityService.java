package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;

public class TafkalQualityService extends QualityService {

    @Override
    public String getQualityServiceName() {
        return "Backstage passes to a TAFKAL80ETC concert";
    }

    @Override
    public Item getQuality(Item item) {
        int quality = increaseQualityIfQualityLessThanFifty(item.getQuality());

        if (item.getSellIn() < 11) {
            quality = increaseQualityIfQualityLessThanFifty(quality);
        }

        if (item.getSellIn() < 6) {
            quality = increaseQualityIfQualityLessThanFifty(quality);
        }

        if (item.getSellIn() < 0) {
            quality = 0;

            quality = decreaseQualityExceptForSulfurasConcert(item.getName(), quality);
        }

        return ItemBuilder.item().clone(item).setQuality(quality).build();
    }
}
