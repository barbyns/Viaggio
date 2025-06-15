package controller;

import entities.Dipendente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import repository.DipendenteRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController<Dipendente> {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @GetMapping
    public <Dipendente> List<Dipendente> getAll() {
        return (List<Dipendente>) dipendenteRepository.findAll();
    }

    @PostMapping
    public Dipendente create(@RequestBody controller.Dipendente d) {
        return DipendenteRepository.save(d);
    }

    @PostMapping("/{id}/upload-foto")
    public ResponseEntity<?> upload(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
        Dipendente d = (Dipendente) dipendenteRepository.findById(id).orElseThrow();
        Path path = Paths.get("uploads/" + file.getOriginalFilename());
        Files.write(path, file.getBytes());
        d.toString(path.toString());
        dipendenteRepository.save(d);
        return ResponseEntity.ok("Upload completato");
    }
}
