package cl.clients.crud.clients.business.facade;

import cl.clients.crud.clients.domain.dto.ClientDTO;
import cl.clients.crud.clients.domain.entity.Client;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ClientFacade {

    Client create(ClientDTO client);

    Client update(ClientDTO client);

    List<Client> findAll();

    Client findById(Long id);

    Long deleteById(Long id);

    CompletableFuture<Void> createClientList(List<ClientDTO> clients);
}
