package dto;

import lombok.Data;

@Data
public class DipendenteDto {
    private Long id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String pathImmagineProfilo;
}
