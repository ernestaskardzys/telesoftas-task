package info.ernestas.gildedrose.controller;

import info.ernestas.gildedrose.model.response.ItemResponse;
import info.ernestas.gildedrose.services.CalculationService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RoseControllerTest {

    private ItemResponse itemResponse;
    private ItemResponse itemResponse2;
    private CalculationService calculationService;
    private RoseController roseController;

    @Before
    public void setUp() {
        calculationService = mock(CalculationService.class);
        roseController = new RoseController(calculationService);

        itemResponse = new ItemResponse(UUID.randomUUID(), "First", 1, 2);
        itemResponse2 = new ItemResponse(UUID.randomUUID(), "Second", 2, 3);
    }

    @Test
    public void testListData() {
        List<ItemResponse> data = Arrays.asList(itemResponse, itemResponse2);
        when(calculationService.listData()).thenReturn(data);

        List<ItemResponse> results = roseController.listData();

        assertThat(results.size(), is(data.size()));
        assertThat(results.get(0).getId(), is(data.get(0).getId()));
        assertThat(results.get(1).getId(), is(data.get(1).getId()));
        verify(calculationService).listData();
    }
}
