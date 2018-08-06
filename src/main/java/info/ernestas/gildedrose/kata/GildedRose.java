package info.ernestas.gildedrose.kata;

import info.ernestas.gildedrose.quality.QualityService;
import info.ernestas.gildedrose.quality.QualityServiceFactory;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    private static final String TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_CONCERT = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE_CONCERT = "Aged Brie";

    public Item[] updateQuality(Item[] items) {
        List<Item> resultingItems = new ArrayList<>();
        for (Item item : items) {
            if (!item.getName().equals(SULFURAS_CONCERT)) {
                item.setSellIn(item.getSellIn() - 1);
            }

            if (item.getName().equals(AGED_BRIE_CONCERT) && item.getName().equals(TAFKAL_80_ETC_CONCERT)) {
                increaseQualityIfQualityLessThanFifty(item);
            }

            QualityService qualityService = QualityServiceFactory.getQualityService(item.getName());
            resultingItems.add(qualityService.getQuality(item));
        }

        return items;
    }

    private void increaseQualityIfQualityLessThanFifty(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(increaseQuality(item));
        }
    }

    private int increaseQuality(Item item) {
        return item.getQuality() + 1;
    }

}
