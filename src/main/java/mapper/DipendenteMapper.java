package mapper;

import dto.DipendenteDto;
import entities.Dipendente;

public class DipendenteMapper {
    public static DipendenteDto toDto(Dipendente d) {
        DipendenteDto dto = new DipendenteDto();
        dto.setId(d.getId());
        dto.setUsername(d.getUsername());
        dto.setNome(d.getNome());
        dto.setCognome(d.getCognome());
        dto.setEmail(d.getEmail());
        dto.setPathImmagineProfilo(d.getPathImmagineProfilo());
        return dto;
    }

    public static Dipendente fromDto(DipendenteDto dto) {
        Dipendente d = new Dipendente();
        d.setId(dto.getId());
        d.setUsername(dto.getUsername());
        d.setNome(dto.getNome());
        d.setCognome(dto.getCognome());
        d.setEmail(dto.getEmail());
        d.setPathImmagineProfilo(dto.getPathImmagineProfilo());
        return d;
    }
}
