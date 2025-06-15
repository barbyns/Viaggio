package mapper;

import dto.DispositivoDto;
import entities.Dispositivo;
import entities.Dispositivo.StatoDispositivo;

public class DispositivoMapper {
    public static DispositivoDto toDto(Dispositivo d) {
        DispositivoDto dto = new DispositivoDto();
        dto.setId(d.getId());
        dto.setTipo(d.getTipo());
        dto.setStato(d.getStato().name());
        if (d.getAssegnatoA() != null) dto.setDipendenteId(d.getAssegnatoA().getId());
        return dto;
    }

    public static Dispositivo fromDto(DispositivoDto dto) {
        Dispositivo d = new Dispositivo();
        d.setId(dto.getId());
        d.setTipo(dto.getTipo());
        d.setStato(StatoDispositivo.valueOf(dto.getStato()));
        return d;
    }
}
