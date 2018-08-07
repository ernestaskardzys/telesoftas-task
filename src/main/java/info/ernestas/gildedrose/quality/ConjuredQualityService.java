package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;

public class ConjuredQualityService extends QualityService {

    @Override
    public String getQualityServiceName() {
        return QualityServiceName.CONJURED.getName();
    }

    @Override
    public int getQuality(Item item) {
        int quality = decreaseQualityExceptForSulfurasConcert(item.getName(), item.getQuality());

        if (item.getSellIn() < 0) {
            quality = decreaseQualityExceptForSulfurasConcert(item.getName(), quality);
        }

        return quality;
    }

}
