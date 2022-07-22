package cl.clients.crud.clients.repository;

import cl.clients.crud.clients.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findClientByDni(String dni);
}
