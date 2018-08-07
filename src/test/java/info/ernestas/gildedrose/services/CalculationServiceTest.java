package info.ernestas.gildedrose.services;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.model.entity.ItemEntity;
import info.ernestas.gildedrose.model.response.ItemResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculationServiceTest {

    private ItemEntity itemEntity;
    private ItemEntity itemEntity2;
    private DataService dataService;
    private CalculationService calculationService;

    @Before
    public void setUp() {
        dataService = mock(DataService.class);
        calculationService = new CalculationService(dataService);

        itemEntity = new ItemEntity(UUID.randomUUID(), "First", 1, 2);
        itemEntity2 = new ItemEntity(UUID.randomUUID(), "Second", 2, 3);
    }

    @Test
    public void testListData() {
        List<ItemEntity> entities = Arrays.asList(itemEntity, itemEntity2);
        when(dataService.findAll()).thenReturn(entities);

        List<ItemResponse> results = calculationService.listData();

        assertThat(results.size(), is(entities.size()));
        assertThat(results.get(0).getName(), is(entities.get(0).getName()));
        assertThat(results.get(1).getName(), is(entities.get(1).getName()));
    }

}
