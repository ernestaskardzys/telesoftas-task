package info.ernestas.gildedrose.services;

import info.ernestas.gildedrose.model.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ItemRepository extends MongoRepository<Item, UUID> {

}
