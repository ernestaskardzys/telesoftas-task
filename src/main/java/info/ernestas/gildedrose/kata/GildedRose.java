package info.ernestas.gildedrose.kata;

public class GildedRose {

    private static final String TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_CONCERT = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE_CONCERT = "Aged Brie";

    public Item[] updateQuality(Item[] items) {
        for (Item item : items) {
            if (!item.getName().equals(SULFURAS_CONCERT)) {
                item.setSellIn(item.getSellIn() - 1);
            }

            if (!item.getName().equals(AGED_BRIE_CONCERT) && !item.getName().equals(TAFKAL_80_ETC_CONCERT)) {
                decreaseQualityExceptForSulfurasConcert(item);
            } else {
                increaseQualityIfQualityLessThanFifty(item);
            }

            if (item.getName().equals(TAFKAL_80_ETC_CONCERT)) {
                if (item.getSellIn() < 11) {
                    increaseQualityIfQualityLessThanFifty(item);
                }

                if (item.getSellIn() < 6) {
                    increaseQualityIfQualityLessThanFifty(item);
                }

                if (item.getSellIn() < 0) {
                    item.setQuality(0);
                }
            }

            if (item.getSellIn() < 0) {
                if (item.getName().equals(AGED_BRIE_CONCERT)) {
                    increaseQualityIfQualityLessThanFifty(item);
                } else {
                    decreaseQualityExceptForSulfurasConcert(item);
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
