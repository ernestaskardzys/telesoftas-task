package info.ernestas.gildedrose.sellin;

import info.ernestas.gildedrose.quality.QualityServiceName;

public class SellInService {

    public int getSellIn(String name, int sellIn) {
        if (!name.equals(QualityServiceName.SULFURAS.getName())) {
            return sellIn - 1;
        }

        return sellIn;
    }

}
