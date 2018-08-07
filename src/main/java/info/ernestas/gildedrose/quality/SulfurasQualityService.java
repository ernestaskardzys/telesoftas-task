package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;

public class SulfurasQualityService extends QualityService {

    @Override
    public String getQualityServiceName() {
        return QualityServiceName.SULFURAS.getName();
    }

    @Override
    public int getQuality(Item item) {
        return decreaseQuality(item);
    }

}
