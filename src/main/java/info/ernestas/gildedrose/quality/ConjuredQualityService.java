package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;

public class ConjuredQualityService extends QualityService {

    @Override
    public String getQualityServiceName() {
        return "Conjured Mana Cake";
    }

    @Override
    public Item getQuality(Item item) {
        return null;
    }

}
