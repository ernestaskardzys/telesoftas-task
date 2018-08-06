package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;

public class AgedQualityService extends QualityService {

    @Override
    public String getQualityServiceName() {
        return "Aged Brie";
    }

    @Override
    public Item getQuality(Item item) {
        return null;
    }

}
