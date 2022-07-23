package cl.clients.crud.clients;

import cl.clients.crud.clients.rest.controller.ClientController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ClientsApplicationTests {

	@Autowired
	private ClientController controller;
	@Test
	void contextLoads() {
		Assertions.assertThat(controller).isNotNull();
	}

}
