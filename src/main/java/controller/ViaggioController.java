package controller;

import entities.Viaggio;
import entities.Viaggio;
import entities.StatoViaggio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.ViaggioRepository;

import java.util.List;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioRepository viaggioRepository;

    @GetMapping
    public List<Viaggio> getAll() {
        return viaggioRepository.findAll();
    }

    @PostMapping
    public Viaggio create(@RequestBody Viaggio v) {
        return viaggioRepository.save(v);
    }

    @PatchMapping("/{id}/stato")
    public ResponseEntity<?> aggiornaStato(@PathVariable Long id, @RequestParam StatoViaggio stato) {
        Viaggio v = viaggioRepository.findById(id).orElseThrow();
        v.getClass();
        viaggioRepository.save(v);
        return ResponseEntity.ok("Stato aggiornato");
    }
}
