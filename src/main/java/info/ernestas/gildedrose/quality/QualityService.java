package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;

public abstract class QualityService {

    private static final String SULFURAS_CONCERT = "Sulfuras, Hand of Ragnaros";

    public abstract String getQualityServiceName();

    public abstract Item getQuality(Item item);

    protected void increaseQualityIfQualityLessThanFifty(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(increaseQuality(item));
        }
    }

    protected void decreaseQualityExceptForSulfurasConcert(Item item) {
        if (!item.getName().equals(SULFURAS_CONCERT)) {
            if (item.getQuality() > 0) {
                item.setQuality(decreaseQuality(item));
            }
        }
    }

    private int increaseQuality(Item item) {
        return item.getQuality() + 1;
    }

    private int decreaseQuality(Item item) {
        return item.getQuality() - 1;
    }

}
