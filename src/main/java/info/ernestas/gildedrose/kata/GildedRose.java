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
            QualityService qualityService = QualityServiceFactory.getQualityService(item.getName());

            final int sellIn = sellInService.getSellIn(item.getName(), item.getSellIn());
            final int quality = qualityService.getQuality(item);

            Item result = ItemBuilder.item().setName(item.getName()).setSellIn(sellIn).setQuality(quality).build();
            results.add(result);
        }

        return results;
    }

}
