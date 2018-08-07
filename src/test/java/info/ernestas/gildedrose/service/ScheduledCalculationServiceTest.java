package info.ernestas.gildedrose.service;

import info.ernestas.gildedrose.model.entity.ItemEntity;
import info.ernestas.gildedrose.quality.QualityServiceName;
import info.ernestas.gildedrose.service.repository.ItemEntityRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Rollback
public class ScheduledCalculationServiceTest {

    @Autowired
    private ItemEntityRepository itemEntityRepository;

    private UUID firstId;
    private UUID secondId;
    private ItemEntity itemEntity;
    private ItemEntity itemEntity2;

    @Autowired
    private ScheduledCalculationService service;

    @Before
    public void setUp() {
        firstId = UUID.randomUUID();
        secondId = UUID.randomUUID();
        itemEntity = new ItemEntity(firstId, QualityServiceName.DEXTERITY.getName(), 10, 20);
        itemEntity2 = new ItemEntity(secondId, QualityServiceName.AGED.getName(), 2, 0);

        itemEntityRepository.save(itemEntity);
        itemEntityRepository.save(itemEntity2);
    }

    @Test
    public void testCalculate() {
        service.calculate();

        List<ItemEntity> itemEntities = itemEntityRepository.findAll();

        ItemEntity firstEntity = itemEntities.stream().filter(i -> i.getId().equals(firstId)).findFirst().get();
        ItemEntity secondEntity = itemEntities.stream().filter(i -> i.getId().equals(secondId)).findFirst().get();

        assertThat(firstEntity.getId(), is(firstId));
        assertThat(firstEntity.getName(), is(itemEntity.getName()));
        assertThat(firstEntity.getSellIn(), is(9));
        assertThat(firstEntity.getQuality(), is(19));
        assertThat(secondEntity.getId(), is(secondId));
        assertThat(secondEntity.getName(), is(itemEntity2.getName()));
        assertThat(secondEntity.getSellIn(), is(1));
        assertThat(secondEntity.getQuality(), is(1));
    }

}
