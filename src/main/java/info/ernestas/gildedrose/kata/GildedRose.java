package info.ernestas.gildedrose.kata;

import info.ernestas.gildedrose.quality.QualityService;
import info.ernestas.gildedrose.quality.QualityServiceFactory;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    private static final String SULFURAS_CONCERT = "Sulfuras, Hand of Ragnaros";

    public List<Item> updateQuality(Item[] items) {
        List<Item> results = new ArrayList<>();
        for (Item item : items) {
            if (!item.getName().equals(SULFURAS_CONCERT)) {
                item.setSellIn(item.getSellIn() - 1);
            }

            QualityService qualityService = QualityServiceFactory.getQualityService(item.getName());
            results.add(qualityService.getQuality(item));
        }

        return results;
    }

}
