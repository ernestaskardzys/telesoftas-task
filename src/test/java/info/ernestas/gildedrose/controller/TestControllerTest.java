package info.ernestas.gildedrose.controller;

import info.ernestas.gildedrose.service.DataService;
import info.ernestas.gildedrose.service.ScheduledCalculationService;
import info.ernestas.gildedrose.service.transformer.ItemToItemEntityTransformer;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestControllerTest {

    private DataService dataService;
    private ItemToItemEntityTransformer transformer;
    private ScheduledCalculationService scheduledCalculationService;

    private TestController testController;

    @Before
    public void setUp() {
        dataService = mock(DataService.class);
        transformer = mock(ItemToItemEntityTransformer.class);
        scheduledCalculationService = mock(ScheduledCalculationService.class);
        testController = new TestController(dataService, transformer, scheduledCalculationService);
    }

    @Test
    public void testInsertTestData() {
        testController.insertTestData();

        verify(transformer).convertToItemEntities(any());
        verify(dataService).saveAll(any());
    }

    @Test
    public void testExecuteScheduler() {
        testController.executeScheduler();

        verify(scheduledCalculationService).calculate();
    }
}
