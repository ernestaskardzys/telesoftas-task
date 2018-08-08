package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;

public class TafkalQualityService extends QualityService {

    @Override
    public String getQualityServiceName() {
        return QualityServiceName.TAFKAL.getName();
    }

    @Override
    public int getQuality(Item item) {
        int quality = item.getQuality();
        int count = getTimes(item.getSellIn());

        for (int i = 0; i < count; i++) {
            quality = increaseQualityFunction().apply(quality);
        }

        if (item.getSellIn() < 0) {
            quality = 0;

            quality = decreaseQualityFunction(item).apply(quality);
        }

        return quality;
    }

    private int getTimes(int sellIn) {
        int times = 1;
        times = sellIn < 11 ? times++ : times;
        times = sellIn < 6 ? times++ : times;

        return times;
    }
}
