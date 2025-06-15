package dto;

import lombok.Data;

@Data
public class DispositivoDto {
    private Long id;
    private String tipo;
    private String stato;
    private Long dipendenteId;
}
