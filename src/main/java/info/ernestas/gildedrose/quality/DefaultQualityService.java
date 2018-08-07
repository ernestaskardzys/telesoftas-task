package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;

public class DefaultQualityService extends QualityService {

    @Override
    public String getQualityServiceName() {
        return QualityServiceName.DEFAULT.getName();
    }

    public int getQuality(Item item) {
        return decreaseQuality(item);
    }

}
