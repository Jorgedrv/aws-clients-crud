package cl.clients.crud.clients.business.facade;

import cl.clients.crud.clients.domain.dto.ClientDTO;
import cl.clients.crud.clients.domain.entity.Client;

import java.util.List;

public interface ClientFacade {

    Client create(ClientDTO client);

    Client update(ClientDTO client);

    List<Client> findAll();

    Client findById(Long id);

    Long deleteById(Long id);
}
