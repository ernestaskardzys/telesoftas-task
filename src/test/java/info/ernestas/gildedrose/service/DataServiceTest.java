package info.ernestas.gildedrose.service;

import info.ernestas.gildedrose.model.entity.ItemEntity;
import info.ernestas.gildedrose.service.repository.ItemEntityRepository;
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

public class DataServiceTest {

    private ItemEntityRepository itemEntityRepository;
    private DataService dataService;
    private ItemEntity itemEntity;
    private ItemEntity itemEntity2;

    @Before
    public void setUp() {
        itemEntityRepository = mock(ItemEntityRepository.class);
        dataService = new DataService(itemEntityRepository);

        itemEntity = new ItemEntity(UUID.randomUUID(), "First", 1, 2);
        itemEntity2 = new ItemEntity(UUID.randomUUID(), "Second", 2, 3);
    }

    @Test
    public void testSaveData() {
        List<ItemEntity> entities = Arrays.asList(itemEntity, itemEntity2);
        when(itemEntityRepository.saveAll(entities)).thenReturn(entities);

        List<ItemEntity> results = dataService.saveAll(entities);

        assertThat(results.get(0), is(itemEntity));
        assertThat(results.get(1), is(itemEntity2));
        verify(itemEntityRepository).saveAll(entities);
    }

    @Test
    public void testFindAll() {
        List<ItemEntity> entities = Arrays.asList(itemEntity, itemEntity2);
        when(itemEntityRepository.findAll()).thenReturn(entities);

        List<ItemEntity> results = dataService.findAll();

        assertThat(results.size(), is(entities.size()));
        assertThat(results.get(0), is(itemEntity));
        assertThat(results.get(1), is(itemEntity2));
    }

}
