package info.ernestas.gildedrose.quality;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QualityServiceFactoryTest {

    @Test
    public void testGetQualityService_aged() {
        QualityService agedQualityService = QualityServiceFactory.getQualityService(QualityServiceName.AGED.getName());

        assertThat(agedQualityService, is(instanceOf(AgedQualityService.class)));
    }

    @Test
    public void testGetQualityService_conjured() {
        QualityService conjuredQualityService = QualityServiceFactory.getQualityService(QualityServiceName.CONJURED.getName());

        assertThat(conjuredQualityService, is(instanceOf(ConjuredQualityService.class)));
    }

    @Test
    public void testGetQualityService_dexterity() {
        QualityService dexterityQualityService = QualityServiceFactory.getQualityService(QualityServiceName.DEXTERITY.getName());

        assertThat(dexterityQualityService, is(instanceOf(DexterityQualityService.class)));
    }

    @Test
    public void testGetQualityService_sulfuras() {
        QualityService sulfurasQualityService = QualityServiceFactory.getQualityService(QualityServiceName.SULFURAS.getName());

        assertThat(sulfurasQualityService, is(instanceOf(SulfurasQualityService.class)));
    }

    @Test
    public void testGetQualityService_tafkal() {
        QualityService tafkalQualityService = QualityServiceFactory.getQualityService(QualityServiceName.TAFKAL.getName());

        assertThat(tafkalQualityService, is(instanceOf(TafkalQualityService.class)));
    }

    @Test
    public void testGetQualityService_elixir() {
        QualityService elixirQualityService = QualityServiceFactory.getQualityService(QualityServiceName.ELIXIR.getName());

        assertThat(elixirQualityService, is(instanceOf(ElixirQualityService.class)));
    }

    @Test(expected = NoQualityServiceException.class)
    public void testGetQualityService_notExistingQualityService() {
        QualityServiceFactory.getQualityService("Not existing concert name");
    }

}
