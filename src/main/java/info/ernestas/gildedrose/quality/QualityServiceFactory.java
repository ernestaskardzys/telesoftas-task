package info.ernestas.gildedrose.quality;

import java.util.ArrayList;
import java.util.List;

public final class QualityServiceFactory {

    private static final List<QualityService> QUALITY_SERVICES;

    static {
        QUALITY_SERVICES = new ArrayList<>();
        QUALITY_SERVICES.add(new ConjuredQualityService());
        QUALITY_SERVICES.add(new AgedQualityService());
        QUALITY_SERVICES.add(new DexterityQualityService());
        QUALITY_SERVICES.add(new SulfurasQualityService());
        QUALITY_SERVICES.add(new TafkalQualityService());
        QUALITY_SERVICES.add(new ElixirQualityService());
    }

    private QualityServiceFactory() {
    }

    public static QualityService getQualityService(String concertName) {
        return QUALITY_SERVICES.stream().filter(s -> s.getQualityServiceName().equals(concertName)).findFirst().orElseThrow(() -> new NoQualityServiceException("Service does not exist"));
    }

}
