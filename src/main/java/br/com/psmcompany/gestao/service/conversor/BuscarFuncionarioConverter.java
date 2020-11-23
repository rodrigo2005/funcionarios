package br.com.psmcompany.gestao.service.conversor;

import br.com.psmcompany.gestao.domain.Funcionario;
import br.com.psmcompany.gestao.service.dto.BuscarFuncionarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuscarFuncionarioConverter extends AbstractConverter<BuscarFuncionarioDTO, Funcionario> {

    @Autowired
    private CargoConverter cargoConverter;

    @Override
    public BuscarFuncionarioDTO toDto(Funcionario funcionario) {
        return BuscarFuncionarioDTO.builder()
                .cargo(cargoConverter.toDto(funcionario.getCargo()))
                .funcionario_id(funcionario.getId())
                .nomeFuncionario(funcionario.getNomeFuncionario())
                .build();
    }

    @Override
    public Funcionario toEntity(BuscarFuncionarioDTO buscarFuncionarioDTO) {
        return Funcionario.builder()
                .id(buscarFuncionarioDTO.getFuncionario_id())
                .cargo(cargoConverter.toEntity(buscarFuncionarioDTO.getCargo()))
                .nomeFuncionario(buscarFuncionarioDTO.getNomeFuncionario())
                .build();
    }
}
