package controller;

import dto.DipendenteDto;
import mapper.DipendenteMapper;
import entities.Dipendente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.DipendenteRepository;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    private final DipendenteRepository dipendenteRepository;

    @Autowired
    public DipendenteController(DipendenteRepository dipendenteRepository) {
        this.dipendenteRepository = dipendenteRepository;
    }

    @GetMapping
    public List<DipendenteDto> getAll() {
        return dipendenteRepository.findAll().stream()
                .map(DipendenteMapper::toDto)
                .toList();
    }

    @PostMapping
    public DipendenteDto create(@RequestBody DipendenteDto dto) {
        Dipendente d = dipendenteRepository.save(DipendenteMapper.fromDto(dto));
        return DipendenteMapper.toDto(d);
    }
}
