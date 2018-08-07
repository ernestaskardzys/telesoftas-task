package info.ernestas.gildedrose.service;

import info.ernestas.gildedrose.model.entity.ItemEntity;
import info.ernestas.gildedrose.model.response.ItemResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculationService {

    private final DataService dataService;

    public CalculationService(DataService dataService) {
        this.dataService = dataService;
    }

    public List<ItemResponse> listData() {
        List<ItemEntity> itemEntities = dataService.findAll();

        return itemEntities.stream().map(itemEntity -> getItem(itemEntity)).collect(Collectors.toList());
    }

    private ItemResponse getItem(ItemEntity itemEntity) {
        return new ItemResponse(itemEntity.getId(), itemEntity.getName(), itemEntity.getSellIn(), itemEntity.getQuality());
    }

}
