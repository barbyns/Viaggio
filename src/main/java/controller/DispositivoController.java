package controller;

import entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import repository.*;

import java.util.List;

@RestController
@RequestMapping("/dispositivi")
public class DispositivoController<Dispositivo> {

    @Autowired
    private DispositivoRepository dispositivoRepository;
    @Autowired
    private DipendenteRepository dipendenteRepository;

    @GetMapping
    public List<Dispositivo> getAll() {
        return dispositivoRepository.findAll();
    }

    @PostMapping
    public Dispositivo create(@RequestBody Dispositivo d) {
        return dispositivoRepository.save(d);
    }

    @PatchMapping("/{id}/assegna")
    public ResponseEntity<?> assegna(@PathVariable Long id, @RequestParam Long dipendenteId) {
        Dispositivo dispositivo = dispositivoRepository.findById(id).orElseThrow();
        Dipendente dipendente = dipendenteRepository.findById(dipendenteId).orElseThrow();

        if (((entities.Dispositivo) dispositivo).getStato() != Dispositivo.StatoDispositivo.DISPONIBILE) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Dispositivo non disponibile");
        }

        dispositivo.setAssegnatoA(dipendente);
        dispositivo.setStato(Dispositivo.StatoDispositivo.ASSEGNATO);
        DipendenteRepository.save(dispositivo);
        return ResponseEntity.ok("Dispositivo assegnato");
    }
}
