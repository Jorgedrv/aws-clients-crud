package cl.clients.crud.clients.business.service;

import cl.clients.crud.clients.business.facade.ClientFacade;
import cl.clients.crud.clients.business.factory.ClientFactory;
import cl.clients.crud.clients.domain.dto.ClientDTO;
import cl.clients.crud.clients.domain.entity.Client;
import cl.clients.crud.clients.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class ClientService implements ClientFacade {

    private final ClientRepository clientRepository;

    @Override
    public Client create(ClientDTO client) {
        try {
            if (null != client.getClientId() || null != findClientByDni(client.getDni())) {
                throw new EntityExistsException("Client exist with DNI: " + client.getDni());
            }
            return clientRepository.save(ClientFactory.getClientEntity(client));
        } catch (Exception ex) {
            throw new PersistenceException(ex.getMessage());
        }
    }

    @Override
    public Client update(ClientDTO client) {
        try {
            if (null == client.getClientId()) {
                throw new EntityExistsException("Id must not be empty or null");
            }
            findById(client.getClientId());
            return clientRepository.save(ClientFactory.getClientEntity(client));
        } catch (Exception ex) {
            throw new PersistenceException(ex.getMessage());
        }
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Long deleteById(Long id) {
        clientRepository.deleteById(id);
        return id;
    }
    private Client findClientByDni(String dni) {
        return clientRepository.findClientByDni(dni);
    }
}
