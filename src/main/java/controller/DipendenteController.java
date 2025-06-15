import dto.DipendenteDto;
import entities.Dipendente;
import mapper.DipendenteMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import repository.DipendenteRepository;


import java.util.List;

@GetMapping
public List<DipendenteDto> getAll() {
    return DipendenteRepository.findAll().stream()
            .map(DipendenteMapper::toDto)
            .toList();
}

@PostMapping
public DipendenteDto create(@RequestBody DipendenteDto dto) {
    Dipendente d = DipendenteRepository.save(DipendenteMapper.fromDto(dto));
    return DipendenteMapper.toDto(d);
}

