package info.ernestas.gildedrose.kata;

public class GildedRose {

    private static final String TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_CONCERT = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE_CONCERT = "Aged Brie";

    public Item[] updateQuality(Item[] items) {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].getName().equals(AGED_BRIE_CONCERT) && !items[i].getName().equals(TAFKAL_80_ETC_CONCERT)) {
                if (items[i].getQuality() > 0) {
                    if (!items[i].getName().equals(SULFURAS_CONCERT)) {
                        items[i].setQuality(items[i].getQuality() - 1);
                    }
                }
            } else {
                if (items[i].getQuality() < 50) {
                    items[i].setQuality(items[i].getQuality() + 1);

                    if (items[i].getName().equals(TAFKAL_80_ETC_CONCERT)) {
                        if (items[i].getSellIn() < 11) {
                            if (items[i].getQuality() < 50) {
                                items[i].setQuality(items[i].getQuality() + 1);
                            }
                        }

                        if (items[i].getSellIn() < 6) {
                            if (items[i].getQuality() < 50) {
                                items[i].setQuality(items[i].getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!items[i].getName().equals(SULFURAS_CONCERT)) {
                items[i].setSellIn(items[i].getSellIn() - 1);
            }

            if (items[i].getSellIn() < 0) {
                if (!items[i].getName().equals(AGED_BRIE_CONCERT)) {
                    if (!items[i].getName().equals(TAFKAL_80_ETC_CONCERT)) {
                        if (items[i].getQuality() > 0) {
                            if (!items[i].getName().equals(SULFURAS_CONCERT)) {
                                items[i].setQuality(items[i].getQuality() - 1);
                            }
                        }
                    } else {
                        items[i].setQuality(items[i].getQuality() - items[i].getQuality());
                    }
                } else {
                    if (items[i].getQuality() < 50) {
                        items[i].setQuality(items[i].getQuality() + 1);
                    }
                }
            }
        }

        return items;
    }
}
