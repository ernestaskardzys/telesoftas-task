package info.ernestas.gildedrose.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "item")
public class ItemEntity {

    @Id
    private UUID id;

    private String name;
    private int sellIn;
    private int quality;

    public ItemEntity(UUID id, String name, int sellIn, int quality) {
        this.id = id;
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

}
