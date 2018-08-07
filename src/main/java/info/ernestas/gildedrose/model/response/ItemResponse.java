package info.ernestas.gildedrose.model.response;

import java.util.UUID;

public class ItemResponse {

    private final UUID id;
    private final String name;
    private final int sellIn;
    private final int quality;

    public ItemResponse() {
        this(null, null, 0, 0);
    }

    public ItemResponse(UUID id, String name, int sellIn, int quality) {
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

}
