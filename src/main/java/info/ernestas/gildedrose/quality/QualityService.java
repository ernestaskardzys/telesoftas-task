package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;

import java.util.function.Function;

public abstract class QualityService {

    private static final int TWO = 2;
    private static final int ONE = 1;
    private static final int FIFTY = 50;

    public abstract String getQualityServiceName();

    public abstract int getQuality(Item item);

    public int decreaseQuality(Item item) {
        return calculateQuality(item, decreaseQualityFunction(item));
    }

    public int increaseQuality(Item item) {
        return calculateQuality(item, increaseQualityFunction());
    }

    protected int increaseQualityIfQualityLessThanFifty(int quality) {
        if (quality < FIFTY) {
            return quality + ONE;
        }

        return quality;
    }

    protected Function<Integer, Integer> increaseQualityFunction() {
        return quality -> increaseQualityIfQualityLessThanFifty( quality);
    }

    protected Function<Integer, Integer> decreaseQualityFunction(Item item) {
        return quality -> decreaseQualityExceptForSulfurasConcert(item.getName(), quality);
    }

    protected int decreaseQualityExceptForSulfurasConcert(String name, int quality) {
        if (!name.equals(QualityServiceName.SULFURAS.getName())) {
            if (quality > 0) {
                return quality - ONE;
            }
        }

        return quality;
    }

    private int calculateQuality(Item item, Function<Integer, Integer> qualityFunction) {
        int times = item.getSellIn() < 0 ? TWO : ONE;

        int quality = item.getQuality();
        for (int i = 0; i < times; i++) {
            quality = qualityFunction.apply(quality);
        }

        return quality;
    }

}
