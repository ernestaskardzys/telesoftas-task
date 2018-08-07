package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;

public abstract class QualityService {

    public abstract String getQualityServiceName();

    public abstract int getQuality(Item item);

    public int decreaseQuality(Item item) {
        int quality = decreaseQualityExceptForSulfurasConcert(item.getName(), item.getQuality());

        if (item.getSellIn() < 0) {
            quality = decreaseQualityExceptForSulfurasConcert(item.getName(), quality);
        }

        return quality;
    }

    public int increaseQuality(Item item) {
        int quality = increaseQualityIfQualityLessThanFifty(item.getQuality());

        if (item.getSellIn() < 0) {
            quality = increaseQualityIfQualityLessThanFifty(quality);
        }

        return quality;
    }

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
