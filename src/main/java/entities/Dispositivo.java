package entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    @Enumerated(EnumType.STRING)
    private StatoDispositivo stato;

    @ManyToOne
    private Dipendente assegnatoA;

    public enum StatoDispositivo {
        DISPONIBILE, ASSEGNATO, IN_MANUTENZIONE, DISMESSO
    }
}