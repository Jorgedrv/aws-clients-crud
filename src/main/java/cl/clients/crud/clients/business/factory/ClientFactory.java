package cl.clients.crud.clients.business.factory;

import cl.clients.crud.clients.domain.dto.ClientDTO;
import cl.clients.crud.clients.domain.entity.Client;
public class ClientFactory {

    private ClientFactory() {
    }

    public static Client getClientEntity(ClientDTO client) {
        return Client.builder()
                .clientId(client.getClientId())
                .dni(client.getDni())
                .address(client.getAddress())
                .email(client.getEmail())
                .cellphone(client.getCellphone())
                .dateBirth(client.getDateBirth())
                .name(client.getName())
                .lastName(client.getLastName())
                .build();
    }
}
