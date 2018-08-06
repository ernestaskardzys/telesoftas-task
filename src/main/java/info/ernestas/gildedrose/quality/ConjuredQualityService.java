package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;

public class ConjuredQualityService extends QualityService {

    @Override
    public String getQualityServiceName() {
        return "Conjured Mana Cake";
    }

    @Override
    public Item getQuality(Item item) {
        int quality = decreaseQualityExceptForSulfurasConcert(item.getName(), item.getQuality());

        if (item.getSellIn() < 0) {
            quality = decreaseQualityExceptForSulfurasConcert(item.getName(), quality);
        }

        return new Item(item.getName(), item.getSellIn(), quality);
    }

}
