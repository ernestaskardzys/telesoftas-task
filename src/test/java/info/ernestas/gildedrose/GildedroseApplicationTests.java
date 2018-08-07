package info.ernestas.gildedrose;

import info.ernestas.gildedrose.model.entity.ItemEntity;
import info.ernestas.gildedrose.model.response.ItemResponse;
import info.ernestas.gildedrose.service.repository.ItemEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Rollback
public class GildedroseApplicationTests {

    private static final String MICROSERVICE_URL = "http://localhost:";

    @LocalServerPort
    private int servicePort;

    @Value("${local.management.port}")
    private int managementPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ItemEntityRepository itemEntityRepository;

    private UUID firstId;
    private UUID secondId;
    private ItemEntity itemEntity;
    private ItemEntity itemEntity2;

    @Test
    public void shouldReturnItems() {
        firstId = UUID.randomUUID();
        secondId = UUID.randomUUID();
        itemEntity = new ItemEntity(firstId, "First", 1, 2);
        itemEntity2 = new ItemEntity(secondId, "Second", 2, 3);

        itemEntityRepository.save(itemEntity);
        itemEntityRepository.save(itemEntity2);

        ResponseEntity<ItemResponse[]> entity = restTemplate.getForEntity(MICROSERVICE_URL + servicePort + "/list", ItemResponse[].class);

        assertThat(entity.getStatusCode(), is(HttpStatus.OK));
        assertThat(entity.getBody()[0].getId(), is(firstId));
        assertThat(entity.getBody()[0].getName(), is(itemEntity.getName()));
        assertThat(entity.getBody()[1].getId(), is(secondId));
        assertThat(entity.getBody()[1].getName(), is(itemEntity2.getName()));
    }

    @Test
    public void serviceShouldWork() {
        ResponseEntity<Map> entity = restTemplate.getForEntity(MICROSERVICE_URL + managementPort + "/actuator/info", Map.class);

        assertThat(entity.getStatusCode(), is(HttpStatus.OK));
    }

}
