package info.ernestas.gildedrose.controller;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;
import info.ernestas.gildedrose.model.entity.ItemEntity;
import info.ernestas.gildedrose.quality.QualityServiceName;
import info.ernestas.gildedrose.service.DataService;
import info.ernestas.gildedrose.service.ScheduledCalculationService;
import info.ernestas.gildedrose.service.transformer.ItemToItemEntityTransformer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/test")
public class TestController {

    private final DataService dataService;
    private final ItemToItemEntityTransformer transformer;
    private final ScheduledCalculationService scheduledCalculationService;

    public TestController(DataService dataService, ItemToItemEntityTransformer transformer, ScheduledCalculationService scheduledCalculationService) {
        this.dataService = dataService;
        this.transformer = transformer;
        this.scheduledCalculationService = scheduledCalculationService;
    }

    @GetMapping("/data")
    public List<ItemEntity> insertTestData() {
        Item item = ItemBuilder.item().setId(UUID.randomUUID()).setName(QualityServiceName.DEXTERITY.getName()).setSellIn(10).setQuality(20).build();
        Item item2 = ItemBuilder.item().setId(UUID.randomUUID()).setName(QualityServiceName.AGED.getName()).setSellIn(2).setQuality(0).build();
        List<Item> items = Arrays.asList(item, item2);

        List<ItemEntity> itemEntities = transformer.convertToItemEntities(items);

        return dataService.saveAll(itemEntities);
    }

    @GetMapping("/scheduler")
    public void executeScheduler() {
        scheduledCalculationService.calculate();
    }

}
