package cl.clients.crud.clients.rest.controller;

import cl.clients.crud.clients.business.facade.ClientFacade;
import cl.clients.crud.clients.domain.dto.ClientDTO;
import cl.clients.crud.clients.domain.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Future;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class ClientController {

    private final ClientFacade clientFacade;

    @PostMapping("client")
    public ResponseEntity<Client> create(@RequestBody ClientDTO client) {
        return ResponseEntity.ok(clientFacade.create(client));
    }

    @PutMapping("client")
    public ResponseEntity<Client> update(@RequestBody ClientDTO client) {
        return ResponseEntity.ok(clientFacade.update(client));
    }

    @GetMapping("clients")
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok(clientFacade.findAll());
    }

    @GetMapping("client/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clientFacade.findById(id));
    }

    @DeleteMapping("client/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(clientFacade.deleteById(id));
    }

    @PostMapping("clients")
    public ResponseEntity<Future<Void>> createClientList(@RequestBody List<ClientDTO> clients) {
        return ResponseEntity.ok(clientFacade.createClientList(clients));
    }
}
