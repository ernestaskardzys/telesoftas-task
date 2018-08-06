package info.ernestas.gildedrose.sellin;

public class SellInService {

    private static final String SULFURAS_CONCERT = "Sulfuras, Hand of Ragnaros";

    public int getSellIn(String name, int sellIn) {
        if (!name.equals(SULFURAS_CONCERT)) {
            return sellIn - 1;
        }

        return sellIn;
    }

}
