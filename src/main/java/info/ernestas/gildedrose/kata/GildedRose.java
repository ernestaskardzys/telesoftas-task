package info.ernestas.gildedrose.kata;

public class GildedRose {

    private static final String TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_CONCERT = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE_CONCERT = "Aged Brie";

    public Item[] updateQuality(Item[] items) {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].getName().equals(AGED_BRIE_CONCERT) && !items[i].getName().equals(TAFKAL_80_ETC_CONCERT)) {
                decreaseQualityExceptForSulfurasConcert(items[i]);
            } else {
                increaseQualityIfQualityLessThanFifty(items[i]);
            }

            if (items[i].getName().equals(TAFKAL_80_ETC_CONCERT)) {
                if (items[i].getSellIn() < 11) {
                    increaseQualityIfQualityLessThanFifty(items[i]);
                }

                if (items[i].getSellIn() < 6) {
                    increaseQualityIfQualityLessThanFifty(items[i]);
                }

                if (items[i].getSellIn() < 0) {
                    items[i].setQuality(0);
                }
            }

            if (!items[i].getName().equals(SULFURAS_CONCERT)) {
                items[i].setSellIn(items[i].getSellIn() - 1);
            }

            if (items[i].getSellIn() < 0) {
                if (items[i].getName().equals(AGED_BRIE_CONCERT)) {
                    increaseQualityIfQualityLessThanFifty(items[i]);
                } else {
                    decreaseQualityExceptForSulfurasConcert(items[i]);
                }
            }
        }

        return items;
    }

    private void decreaseQualityExceptForSulfurasConcert(Item item) {
        if (!item.getName().equals(SULFURAS_CONCERT)) {
            if (item.getQuality() > 0) {
                item.setQuality(decreaseQuality(item));
            }
        }
    }

    private void increaseQualityIfQualityLessThanFifty(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(increaseQuality(item));
        }
    }

    private int increaseQuality(Item item) {
        return item.getQuality() + 1;
    }

    private int decreaseQuality(Item item) {
        return item.getQuality() - 1;
    }
}
