package info.ernestas.gildedrose.kata;

import info.ernestas.gildedrose.quality.QualityService;
import info.ernestas.gildedrose.quality.QualityServiceFactory;
import info.ernestas.gildedrose.sellin.SellInService;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    private SellInService sellInService = new SellInService();

    public List<Item> updateQuality(Item[] items) {
        List<Item> results = new ArrayList<>();
        for (Item item : items) {
            item = sellInService.getSellIn(item);

            QualityService qualityService = QualityServiceFactory.getQualityService(item.getName());
            results.add(qualityService.getQuality(item));
        }

        return results;
    }

}
