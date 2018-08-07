package info.ernestas.gildedrose.service;

import info.ernestas.gildedrose.model.entity.ItemEntity;
import info.ernestas.gildedrose.service.repository.ItemEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    private final ItemEntityRepository itemEntityRepository;

    public DataService(ItemEntityRepository itemEntityRepository) {
        this.itemEntityRepository = itemEntityRepository;
    }

    public List<ItemEntity> saveAll(List<ItemEntity> itemEntities) {
        return itemEntityRepository.saveAll(itemEntities);
    }

    public List<ItemEntity> findAll() {
        return itemEntityRepository.findAll();
    }
}
