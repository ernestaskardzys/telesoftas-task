package info.ernestas.gildedrose.sellin;

import info.ernestas.gildedrose.kata.Item;

public class SellInService {

    private static final String SULFURAS_CONCERT = "Sulfuras, Hand of Ragnaros";

    public Item getSellIn(Item item) {
        if (!item.getName().equals(SULFURAS_CONCERT)) {
            item.setSellIn(item.getSellIn() - 1);
        }

        return item;
    }

}
