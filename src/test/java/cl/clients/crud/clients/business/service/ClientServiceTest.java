package cl.clients.crud.clients.business.service;

import cl.clients.crud.clients.domain.dto.ClientDTO;
import cl.clients.crud.clients.domain.entity.Client;
import cl.clients.crud.clients.mock.ClientMock;
import cl.clients.crud.clients.repository.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.PersistenceException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    private ClientRepository repository;

    @InjectMocks
    private ClientService service;

    @Test
    void testClientCreateNullClientIdShouldThrowException() {
        ClientDTO request = ClientMock.getCreateRequest();
        request.setClientId(Long.valueOf(324234234));
        Assertions.assertThrows(PersistenceException.class, () -> service.create(request));
    }

    @Test
    void testClientCreateExistingClientShouldThrowException() {
        when(repository.findClientByDni("324234234")).thenReturn(ClientMock.getClientCreateResponse());
        ClientDTO request = ClientMock.getCreateRequest();
        Assertions.assertThrows(PersistenceException.class, () -> service.create(request));
    }

    @Test
    void testClientCreateShouldReturnOk() {
        Client clientRequest = ClientMock.getClientCreateResponse();
        clientRequest.setClientId(null);
        when(repository.findClientByDni("324234234")).thenReturn(null);
        when(repository.save(clientRequest))
                .thenReturn(ClientMock.getClientCreateResponse());
        ClientDTO request = ClientMock.getCreateRequest();
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
        Assertions.assertEquals(expected, service.create(request));
    }

    @Test
    void testClientUpdateNullClientIdShouldThrowException() {
        ClientDTO request = ClientMock.getCreateRequest();
        Assertions.assertThrows(PersistenceException.class, () -> service.update(request));
    }

    @Test
    void testClientUpdateExistingClientShouldThrowException() {
        when(repository.findById(Long.valueOf(100))).thenReturn(Optional.empty());
        ClientDTO request = ClientMock.getUpdateRequest();
        Assertions.assertThrows(PersistenceException.class, () -> service.update(request));
    }

    @Test
    void testClientUpdateShouldReturnOk() {
        when(repository.findById(Long.valueOf(100)))
                .thenReturn(Optional.ofNullable(ClientMock.getClientUpdateResponse()));
        Client toUpdate = Client.builder()
                .clientId(Long.valueOf(100))
                .dni("324234234")
                .name("Rick")
                .lastName("Brown")
                .email("rbrown@gmail.com")
                .address("13th Street. 47 W 13th St, New York")
                .cellphone("56947584957")
                .dateBirth(LocalDate.of(1980, 2, 21))
                .build();
        when(repository.save(toUpdate)).thenReturn(toUpdate);
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
        Assertions.assertEquals(expected, service.update(ClientMock.getUpdateRequest()));
    }

    @Test
    void testFindAllShouldReturnOk() {
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
        when(repository.findAll()).thenReturn(ClientMock.getClientListResponse());
        Assertions.assertEquals(clients, service.findAll());
    }

    @Test
    void testDeleteByIdShouldReturnOk() {
        doNothing().when(repository).deleteById(Long.valueOf(100));
        Assertions.assertEquals(Long.valueOf(100), service.deleteById(Long.valueOf(100)));
    }
}
