package info.ernestas.gildedrose.kata;

import info.ernestas.gildedrose.quality.QualityService;
import info.ernestas.gildedrose.quality.QualityServiceFactory;

public class GildedRose {

    private static final String SULFURAS_CONCERT = "Sulfuras, Hand of Ragnaros";

    public Item[] updateQuality(Item[] items) {
        for (Item item : items) {
            if (!item.getName().equals(SULFURAS_CONCERT)) {
                item.setSellIn(item.getSellIn() - 1);
            }

            QualityService qualityService = QualityServiceFactory.getQualityService(item.getName());
            qualityService.getQuality(item);
        }

        return items;
    }

}
