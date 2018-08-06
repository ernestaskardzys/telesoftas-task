package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;

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

        return ItemBuilder.item().clone(item).setQuality(quality).build();
    }

}
