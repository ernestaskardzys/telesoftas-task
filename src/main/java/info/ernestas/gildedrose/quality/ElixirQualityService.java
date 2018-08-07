package info.ernestas.gildedrose.quality;

import info.ernestas.gildedrose.kata.Item;

public class ElixirQualityService extends QualityService {

    @Override
    public String getQualityServiceName() {
        return QualityServiceName.ELIXIR.getName();
    }

    @Override
    public int getQuality(Item item) {
        return decreaseQuality(item);
    }

}
