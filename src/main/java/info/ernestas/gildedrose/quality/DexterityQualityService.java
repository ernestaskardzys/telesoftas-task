package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;

public class DexterityQualityService extends QualityService {

    @Override
    public String getQualityServiceName() {
        return QualityServiceName.DEXTERITY.getName();
    }

    @Override
    public int getQuality(Item item) {
        return decreaseQuality(item);
    }

}
