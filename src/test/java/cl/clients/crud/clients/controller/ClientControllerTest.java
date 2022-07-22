package cl.clients.crud.clients.controller;

import cl.clients.crud.clients.business.facade.ClientFacade;
import cl.clients.crud.clients.domain.dto.ClientDTO;
import cl.clients.crud.clients.domain.entity.Client;
import cl.clients.crud.clients.mock.ClientMock;
import cl.clients.crud.clients.rest.controller.ClientController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {

    @Mock
    private ClientFacade clientFacade;

    @InjectMocks
    private ClientController controller;

    @Test
    void testClientCreateShouldReturnOk() {
        Client expected = Client.builder()
                .clientId(Long.valueOf(1))
                .dni("324234234")
                .name("Joseph")
                .lastName("Pierce")
                .email("jpierce@gmail.com")
                .address("345 Casper Dr, Spring Hill")
                .cellphone("5694945876")
                .dateBirth(LocalDate.of(1992, 8, 10))
                .build();
        when(clientFacade.create(ClientMock.getCreateRequest()))
                .thenReturn(ClientMock.getClientCreateResponse());
        Assertions.assertEquals(ResponseEntity.ok(expected), controller.create(ClientMock.getCreateRequest()));
    }

    @Test
    void testClientUpdateShouldReturnOk() {
        Client expected = Client.builder()
                .clientId(Long.valueOf(100))
                .dni("324234234")
                .name("Rick")
                .lastName("Brown")
                .email("rbrown@gmail.com")
                .address("13th Street. 47 W 13th St, New York")
                .cellphone("56947584957")
                .dateBirth(LocalDate.of(1980, 2, 21))
                .build();
        when(clientFacade.update(ClientMock.getUpdateRequest()))
                .thenReturn(ClientMock.getClientUpdateResponse());
        Assertions.assertEquals(ResponseEntity.ok(expected), controller.update(ClientMock.getUpdateRequest()));
    }

    @Test
    void testClientFindAllShouldReturnClientList() {
        Client expected = Client.builder()
                .clientId(Long.valueOf(100))
                .dni("324234234")
                .name("Rick")
                .lastName("Brown")
                .email("rbrown@gmail.com")
                .address("13th Street. 47 W 13th St, New York")
                .cellphone("56947584957")
                .dateBirth(LocalDate.of(1980, 2, 21))
                .build();
        Client expected2 = Client.builder()
                .clientId(Long.valueOf(101))
                .dni("324234535")
                .name("George")
                .lastName("James")
                .email("georgejames@gmail.com")
                .address("13th Street. 47 W 13th St, New York")
                .cellphone("56947584567")
                .dateBirth(LocalDate.of(1985, 5, 5))
                .build();
        List<Client> clients = List.of(expected, expected2);
        when(clientFacade.findAll())
                .thenReturn(ClientMock.getClientListResponse());
        Assertions.assertEquals(ResponseEntity.ok(clients), controller.findAll());
    }

    @Test
    void testClientFindByIdShouldReturnClient() {
        Client expected = Client.builder()
                .clientId(Long.valueOf(100))
                .dni("324234234")
                .name("Rick")
                .lastName("Brown")
                .email("rbrown@gmail.com")
                .address("13th Street. 47 W 13th St, New York")
                .cellphone("56947584957")
                .dateBirth(LocalDate.of(1980, 2, 21))
                .build();
        when(clientFacade.findById(Long.valueOf(100)))
                .thenReturn(ClientMock.getClientListResponse().get(0));
        Assertions.assertEquals(ResponseEntity.ok(expected), controller.findById(Long.valueOf(100)));
    }

    @Test
    void testClientDeleteByIdShouldReturnClientId() {
        when(clientFacade.deleteById(Long.valueOf(100)))
                .thenReturn(Long.valueOf(100));
        Assertions.assertEquals(ResponseEntity.ok(Long.valueOf(100)), controller.deleteById(Long.valueOf(100)));
    }
}
