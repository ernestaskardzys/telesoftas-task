package info.ernestas.gildedrose.kata;

import info.ernestas.gildedrose.quality.QualityService;
import info.ernestas.gildedrose.quality.QualityServiceFactory;
import info.ernestas.gildedrose.sellin.SellInService;

public class RoseWorker {

    private SellInService sellInService = new SellInService();

    public Item getItem(Item item) {
        QualityService qualityService = QualityServiceFactory.getQualityService(item.getName());

        final int sellIn = sellInService.getSellIn(item.getName(), item.getSellIn());
        final int quality = qualityService.getQuality(item);

        return ItemBuilder.item().setId(item.getId()).setName(item.getName()).setSellIn(sellIn).setQuality(quality).build();
    }

}
