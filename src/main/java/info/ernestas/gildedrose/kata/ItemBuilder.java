package info.ernestas.gildedrose.kata;

import java.util.UUID;

public class ItemBuilder {

    private UUID id;
    private String name;
    private int sellIn;
    private int quality;

    private ItemBuilder() {

    }

    public static ItemBuilder item() {
        return new ItemBuilder();
    }

    public ItemBuilder setId(UUID id) {
        this.id = id;
        return this;
    }

    public ItemBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ItemBuilder setSellIn(int sellIn) {
        this.sellIn = sellIn;
        return this;
    }

    public ItemBuilder setQuality(int quality) {
        this.quality = quality;
        return this;
    }

    public ItemBuilder clone(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.sellIn = item.getSellIn();
        this.quality = item.getQuality();
        return this;
    }

    public Item build() {
        return new Item(id, name, sellIn, quality);
    }

}
