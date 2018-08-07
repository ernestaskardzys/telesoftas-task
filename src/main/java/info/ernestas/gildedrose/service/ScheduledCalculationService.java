package info.ernestas.gildedrose.service;

import info.ernestas.gildedrose.kata.GildedRose;
import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.model.entity.ItemEntity;
import info.ernestas.gildedrose.service.transformer.ItemToItemEntityTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ScheduledCalculationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledCalculationService.class);

    private GildedRose gildedRose;
    private final DataService dataService;
    private final ItemToItemEntityTransformer transformer;

    public ScheduledCalculationService(DataService dataService, ItemToItemEntityTransformer transformer) {
        this.dataService = dataService;
        this.transformer = transformer;
        gildedRose = new GildedRose();
    }

    @Scheduled(cron = "${scheduler.calculation.delay}")
    public void calculate() {
        LOGGER.info("Scheduler running");

        List<ItemEntity> entities = dataService.findAll();

        List<Item> items = entities.stream().map(e -> transformer.convertToItem(e)).collect(toList());
        List<Item> convertedItems = gildedRose.updateQuality(items.stream().toArray(i -> new Item[items.size()]));

        List<ItemEntity> convertedEntities = convertedItems.stream().map(e -> transformer.convertToItemEntity(e)).collect(toList());
        convertedEntities.forEach(item -> dataService.save(item));
    }

}
