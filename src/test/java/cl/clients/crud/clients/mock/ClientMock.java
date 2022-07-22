package cl.clients.crud.clients.mock;

import cl.clients.crud.clients.domain.dto.ClientDTO;
import cl.clients.crud.clients.domain.entity.Client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientMock {

    public static ClientDTO getCreateRequest() {
        return ClientDTO.builder()
                .dni("324234234")
                .name("Joseph")
                .lastName("Pierce")
                .email("jpierce@gmail.com")
                .address("345 Casper Dr, Spring Hill")
                .cellphone("5694945876")
                .dateBirth(LocalDate.of(1992, 8, 10))
                .build();
    }

    public static ClientDTO getUpdateRequest() {
        return ClientDTO.builder()
                .clientId(Long.valueOf(100))
                .dni("324234234")
                .name("Rick")
                .lastName("Brown")
                .email("rbrown@gmail.com")
                .address("13th Street. 47 W 13th St, New York")
                .cellphone("56947584957")
                .dateBirth(LocalDate.of(1980, 2, 21))
                .build();
    }

    public static Client getClientCreateResponse() {
        return Client.builder()
                .clientId(Long.valueOf(1))
                .dni("324234234")
                .name("Joseph")
                .lastName("Pierce")
                .email("jpierce@gmail.com")
                .address("345 Casper Dr, Spring Hill")
                .cellphone("5694945876")
                .dateBirth(LocalDate.of(1992, 8, 10))
                .build();
    }

    public static Client getClientUpdateResponse() {
        return Client.builder()
                .clientId(Long.valueOf(100))
                .dni("324234234")
                .name("Rick")
                .lastName("Brown")
                .email("rbrown@gmail.com")
                .address("13th Street. 47 W 13th St, New York")
                .cellphone("56947584957")
                .dateBirth(LocalDate.of(1980, 2, 21))
                .build();
    }

    public static List<Client> getClientListResponse() {
        List<Client> list = new ArrayList<>();
        Client client1 = Client.builder()
                .clientId(Long.valueOf(100))
                .dni("324234234")
                .name("Rick")
                .lastName("Brown")
                .email("rbrown@gmail.com")
                .address("13th Street. 47 W 13th St, New York")
                .cellphone("56947584957")
                .dateBirth(LocalDate.of(1980, 2, 21))
                .build();
        Client client2 = Client.builder()
                .clientId(Long.valueOf(101))
                .dni("324234535")
                .name("George")
                .lastName("James")
                .email("georgejames@gmail.com")
                .address("13th Street. 47 W 13th St, New York")
                .cellphone("56947584567")
                .dateBirth(LocalDate.of(1985, 5, 5))
                .build();
        list.add(client1);
        list.add(client2);
        return list;
    }

    public static List<ClientDTO> getCreateClientListRequest() {
        List<ClientDTO> list = new ArrayList<>();
        ClientDTO client1 = ClientDTO.builder()
                .dni("678456778")
                .name("John")
                .lastName("Goodman")
                .email("jgoodman@gmail.com")
                .address("13th Street. 101 W 13th St, New York")
                .cellphone("56947586735")
                .dateBirth(LocalDate.of(1963, 2, 15))
                .build();
        ClientDTO client2 = ClientDTO.builder()
                .dni("678456778")
                .name("Jimmy")
                .lastName("Forrest")
                .email("jforrest@gmail.com")
                .address("13th Street. 156 W 13th St, New York")
                .cellphone("56968581332")
                .dateBirth(LocalDate.of(1970, 3, 29))
                .build();
        list.add(client1);
        list.add(client2);
        return list;
    }
}
