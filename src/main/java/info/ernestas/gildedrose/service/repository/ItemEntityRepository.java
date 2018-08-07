package info.ernestas.gildedrose.service.repository;

import info.ernestas.gildedrose.model.entity.ItemEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ItemEntityRepository extends MongoRepository<ItemEntity, UUID> {

}
