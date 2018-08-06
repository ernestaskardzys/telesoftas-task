package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;

public class DexterityQualityService extends QualityService {

    @Override
    public String getQualityServiceName() {
        return "+5 Dexterity Vest";
    }

    @Override
    public Item getQuality(Item item) {
        return null;
    }

}
