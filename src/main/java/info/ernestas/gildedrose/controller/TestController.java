package info.ernestas.gildedrose.controller;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;
import info.ernestas.gildedrose.model.entity.ItemEntity;
import info.ernestas.gildedrose.quality.QualityServiceName;
import info.ernestas.gildedrose.service.DataService;
import info.ernestas.gildedrose.service.transformer.ItemToItemEntityTransformer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private final DataService dataService;
    private final ItemToItemEntityTransformer transformer;

    public TestController(DataService dataService, ItemToItemEntityTransformer transformer) {
        this.dataService = dataService;
        this.transformer = transformer;
    }

    @GetMapping("/data")
    public void insertTestData() {
        Item item = ItemBuilder.item().setName(QualityServiceName.DEXTERITY.getName()).setSellIn(10).setQuality(20).build();
        Item item2 = ItemBuilder.item().setName(QualityServiceName.AGED.getName()).setSellIn(2).setQuality(0).build();

        ItemEntity itemEntity = transformer.convertToItemEntity(item);
        ItemEntity itemEntity2 = transformer.convertToItemEntity(item2);

        dataService.save(itemEntity);
        dataService.save(itemEntity2);
    }

}
