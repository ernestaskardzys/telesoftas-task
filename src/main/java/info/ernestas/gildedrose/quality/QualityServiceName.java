package info.ernestas.gildedrose.quality;

public enum QualityServiceName {

    AGED("Aged Brie"),
    CONJURED("Conjured Mana Cake"),
    DEFAULT("Default"),
    DEXTERITY("+5 Dexterity Vest"),
    ELIXIR("Elixir of the Mongoose"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    TAFKAL("Backstage passes to a TAFKAL80ETC concert");

    private final String name;

    QualityServiceName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
