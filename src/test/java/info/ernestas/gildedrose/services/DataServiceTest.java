package info.ernestas.gildedrose.services;

import info.ernestas.gildedrose.model.entity.ItemEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DataServiceTest {

    private ItemEntityRepository itemEntityRepository;
    private DataService dataService;

    @Before
    public void setUp() {
        itemEntityRepository = mock(ItemEntityRepository.class);
        dataService = new DataService(itemEntityRepository);
    }

    @Test
    public void testSaveData() {
        ItemEntity itemEntity = new ItemEntity(UUID.randomUUID(), "First", 1, 2);
        when(itemEntityRepository.save(itemEntity)).thenReturn(itemEntity);

        ItemEntity result = dataService.save(itemEntity);

        assertThat(result.getId(), is(itemEntity.getId()));
        assertThat(result.getName(), is(itemEntity.getName()));
        assertThat(result.getSellIn(), is(itemEntity.getSellIn()));
        assertThat(result.getQuality(), is(itemEntity.getQuality()));
        verify(itemEntityRepository).save(itemEntity);
    }
}
