package info.ernestas.gildedrose.kata;

public class ItemBuilder {

    private String name;
    private int sellIn;
    private int quality;

    private ItemBuilder() {

    }

    public static ItemBuilder item() {
        return new ItemBuilder();
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

    public Item build() {
        return new Item(name, sellIn, quality);
    }

}
