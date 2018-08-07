package info.ernestas.gildedrose.kata;

import java.util.UUID;

public class Item {

    private final UUID id;
    private final String name;
    private final int sellIn;
    private final int quality;

    public Item() {
        this(null, null, 0, 0);
    }

    public Item(UUID id, String name, int sellIn, int quality) {
        this.id = id;
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    @Override
    public String toString() {
        return this.id + ", "+ this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
