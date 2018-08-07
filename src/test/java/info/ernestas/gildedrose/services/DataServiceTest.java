package info.ernestas.gildedrose.services;

import info.ernestas.gildedrose.model.entity.ItemEntity;
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
        when(itemEntityRepository.save(itemEntity)).thenReturn(itemEntity);

        ItemEntity result = dataService.save(itemEntity);

        assertThat(result.getId(), is(itemEntity.getId()));
        assertThat(result.getName(), is(itemEntity.getName()));
        assertThat(result.getSellIn(), is(itemEntity.getSellIn()));
        assertThat(result.getQuality(), is(itemEntity.getQuality()));
        verify(itemEntityRepository).save(itemEntity);
    }

    @Test
    public void testFindAll() {
        List<ItemEntity> entities = Arrays.asList(itemEntity, itemEntity2);
        when(itemEntityRepository.findAll()).thenReturn(entities);

        List<ItemEntity> results = dataService.findAll();

        assertThat(results.size(), is(entities.size()));
        assertThat(results.get(0).getId(), is(entities.get(0).getId()));
        assertThat(results.get(1).getId(), is(entities.get(1).getId()));
    }

}
