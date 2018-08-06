package info.ernestas.gildedrose.quality;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QualityServiceFactoryTest {

    @Test
    public void testGetQualityService_aged() {
        QualityService agedQualityService = QualityServiceFactory.getQualityService("Aged Brie");

        assertThat(agedQualityService, is(instanceOf(AgedQualityService.class)));
    }

    @Test
    public void testGetQualityService_conjured() {
        QualityService conjuredQualityService = QualityServiceFactory.getQualityService("Conjured Mana Cake");

        assertThat(conjuredQualityService, is(instanceOf(ConjuredQualityService.class)));
    }

    @Test
    public void testGetQualityService_dexterity() {
        QualityService dexterityQualityService = QualityServiceFactory.getQualityService("+5 Dexterity Vest");

        assertThat(dexterityQualityService, is(instanceOf(DexterityQualityService.class)));
    }

    @Test
    public void testGetQualityService_sulfuras() {
        QualityService sulfurasQualityService = QualityServiceFactory.getQualityService("Sulfuras, Hand of Ragnaros");

        assertThat(sulfurasQualityService, is(instanceOf(SulfurasQualityService.class)));
    }

    @Test
    public void testGetQualityService_tafkal() {
        QualityService tafkalQualityService = QualityServiceFactory.getQualityService("Backstage passes to a TAFKAL80ETC concert");

        assertThat(tafkalQualityService, is(instanceOf(TafkalQualityService.class)));
    }

    @Test(expected = NoQualityServiceException.class)
    public void testGetQualityService_notExistingQualityService() {
        QualityServiceFactory.getQualityService("Not existing concert name");
    }

}
