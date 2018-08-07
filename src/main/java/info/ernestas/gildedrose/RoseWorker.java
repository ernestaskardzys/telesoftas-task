package info.ernestas.gildedrose;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;
import info.ernestas.gildedrose.quality.QualityService;
import info.ernestas.gildedrose.quality.QualityServiceFactory;
import info.ernestas.gildedrose.sellin.SellInService;

public class RoseWorker {

    private SellInService sellInService = new SellInService();

    public Item getItem(Item item) {
        QualityService qualityService = QualityServiceFactory.getQualityService(item.getName());

        final int sellIn = sellInService.getSellIn(item.getName(), item.getSellIn());
        final int quality = qualityService.getQuality(item);

        return ItemBuilder.item().setName(item.getName()).setSellIn(sellIn).setQuality(quality).build();
    }

}
