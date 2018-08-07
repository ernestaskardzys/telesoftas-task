package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;

public abstract class QualityService {

    public abstract String getQualityServiceName();

    public abstract int getQuality(Item item);

    protected int increaseQualityIfQualityLessThanFifty(int quality) {
        if (quality < 50) {
            return quality + 1;
        }

        return quality;
    }

    protected int decreaseQualityExceptForSulfurasConcert(String name, int quality) {
        if (!name.equals(QualityServiceName.SULFURAS.getName())) {
            if (quality > 0) {
                return quality - 1;
            }
        }

        return quality;
    }

}
