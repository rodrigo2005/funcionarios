package br.com.psmcompany.gestao.service.conversor;

import br.com.psmcompany.gestao.domain.Cargo;
import br.com.psmcompany.gestao.service.dto.CargoDTO;
import org.springframework.stereotype.Component;

@Component
public class CargoConverter extends AbstractConverter<CargoDTO, Cargo> {


    @Override
    public CargoDTO toDto(Cargo cargo) {
        return CargoDTO.builder()
                .cargo_id(cargo.getId())
                .nomeCargo(cargo.getNomeCargo())
                .build();

    }

    @Override
    public Cargo toEntity(CargoDTO cargoDTO) {
        return Cargo.builder()
                .id(cargoDTO.getCargo_id())
                .nomeCargo(cargoDTO.getNomeCargo())
                .build();
    }
}
