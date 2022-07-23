package cl.clients.crud.clients.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Long clientId;
    private String dni;
    private String name;
    private String lastName;
    private String email;
    private String cellphone;
    private String address;
    private LocalDate dateBirth;
}
