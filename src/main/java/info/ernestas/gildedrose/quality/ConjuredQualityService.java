package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;

public class ConjuredQualityService extends QualityService {

    @Override
    public String getQualityServiceName() {
        return QualityServiceName.CONJURED.getName();
    }

    @Override
    public int getQuality(Item item) {
        return decreaseQuality(item);
    }

}
