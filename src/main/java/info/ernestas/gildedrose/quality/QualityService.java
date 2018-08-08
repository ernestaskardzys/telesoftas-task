package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;

public abstract class QualityService {

    private static final int TWO = 2;
    private static final int ONE = 1;
    private static final int FIFTY = 50;

    public abstract String getQualityServiceName();

    public abstract int getQuality(Item item);

    public int decreaseQuality(Item item) {
        int decreaseCount = item.getSellIn() < 0 ? TWO : ONE;

        int quality = item.getQuality();
        for (int i = 0; i < decreaseCount; i++) {
            quality = decreaseQualityExceptForSulfurasConcert(item.getName(), quality);
        }

        return quality;
    }

    public int increaseQuality(Item item) {
        int increaseCount = item.getSellIn() < 0 ? TWO : ONE;

        int quality = item.getQuality();
        for (int i = 0; i < increaseCount; i++) {
            quality = increaseQualityIfQualityLessThanFifty(quality);
        }

        return quality;
    }

    protected int increaseQualityIfQualityLessThanFifty(int quality) {
        if (quality < FIFTY) {
            return quality + ONE;
        }

        return quality;
    }

    protected int decreaseQualityExceptForSulfurasConcert(String name, int quality) {
        if (!name.equals(QualityServiceName.SULFURAS.getName())) {
            if (quality > 0) {
                return quality - ONE;
            }
        }

        return quality;
    }

}
