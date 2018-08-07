package info.ernestas.gildedrose;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.model.entity.ItemEntity;
import info.ernestas.gildedrose.model.response.ItemResponse;
import info.ernestas.gildedrose.services.ItemEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GildedroseApplicationTests {

    private static final String MICROSERVICE_URL = "http://localhost:";

    @LocalServerPort
    private int servicePort;

    @Value("${local.management.port}")
    private int managementPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ItemEntityRepository itemEntityRepository;

    private ItemEntity itemEntity;
    private ItemEntity itemEntity2;

    @Test
    public void shouldReturnItems_currentJustOne() {
        itemEntity = new ItemEntity(UUID.randomUUID(), "First", 1, 2);
        itemEntity2 = new ItemEntity(UUID.randomUUID(), "Second", 2, 3);
        List<ItemEntity> entities = Arrays.asList(itemEntity, itemEntity2);
        when(itemEntityRepository.findAll()).thenReturn(entities);

        ResponseEntity<ItemResponse[]> entity = restTemplate.getForEntity(MICROSERVICE_URL + servicePort + "/list", ItemResponse[].class);

        assertThat(entity.getStatusCode(), is(HttpStatus.OK));
        assertThat(entity.getBody()[0].getName(), is("First"));
        assertThat(entity.getBody()[1].getName(), is("Second"));
    }

    @Test
    public void serviceShouldWork() {
        ResponseEntity<Map> entity = restTemplate.getForEntity(MICROSERVICE_URL + managementPort + "/actuator/info", Map.class);

        assertThat(entity.getStatusCode(), is(HttpStatus.OK));
    }

}
