package repository;

import entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
    static <Dipendente> Dipendente save(controller.Dipendente d) {
        return null;
    }
}