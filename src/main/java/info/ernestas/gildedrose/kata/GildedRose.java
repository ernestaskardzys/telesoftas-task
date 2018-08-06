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
            int sellIn = sellInService.getSellIn(item.getName(), item.getSellIn());

            Item updatedSellInItem = ItemBuilder.item().clone(item).setSellIn(sellIn).build();
            QualityService qualityService = QualityServiceFactory.getQualityService(updatedSellInItem.getName());
            results.add(qualityService.getQuality(updatedSellInItem));
        }

        return results;
    }

}
