package entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String pathImmagineProfilo;

    @OneToMany(mappedBy = "assegnatoA")
    private List<Dispositivo> dispositivi;
}
