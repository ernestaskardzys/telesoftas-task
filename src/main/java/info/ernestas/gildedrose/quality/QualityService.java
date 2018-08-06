package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;

public abstract class QualityService {

    private static final String SULFURAS_CONCERT = "Sulfuras, Hand of Ragnaros";

    public abstract String getQualityServiceName();

    public abstract Item getQuality(Item item);

    protected int increaseQualityIfQualityLessThanFifty(int quality) {
        if (quality < 50) {
            return quality + 1;
        }

        return quality;
    }

    protected int decreaseQualityExceptForSulfurasConcert(String name, int quality) {
        if (!name.equals(SULFURAS_CONCERT)) {
            if (quality > 0) {
                return quality - 1;
            }
        }

        return quality;
    }

}
