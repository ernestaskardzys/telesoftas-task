package info.ernestas.gildedrose;

import info.ernestas.gildedrose.kata.Item;
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

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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

	@Test
	public void shouldReturnItems_currentJustOne() {
		ResponseEntity<Item> entity = restTemplate.getForEntity(MICROSERVICE_URL + servicePort + "/list", Item.class);

		assertThat(entity.getStatusCode(), is(HttpStatus.OK));
		assertThat(entity.getBody().getName(), is("Test"));
	}

	@Test
	public void serviceShouldWork() {
		ResponseEntity<Map> entity = restTemplate.getForEntity(MICROSERVICE_URL + managementPort + "/actuator/info", Map.class);

		assertThat(entity.getStatusCode(), is(HttpStatus.OK));
	}

}
