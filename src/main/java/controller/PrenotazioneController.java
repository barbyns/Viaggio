package controller;


import entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import repository.*;

import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private DipendenteRepository dipendenteRepository;
    @Autowired
    private ViaggioRepository viaggioRepository;

    @GetMapping
    public List<Prenotazione> getAll() {
        return prenotazioneRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Prenotazione p) {
        if (prenotazioneRepository.existsByDipendenteAndDataRichiesta(p.getDipendente(), p.getDataRichiesta())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Dipendente già prenotato in questa data");
        }
        return ResponseEntity.ok(prenotazioneRepository.save(p));
    }
}
