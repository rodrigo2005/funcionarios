package br.com.psmcompany.gestao.service.conversor;

import br.com.psmcompany.gestao.domain.Cargo;
import br.com.psmcompany.gestao.domain.Departamento;
import br.com.psmcompany.gestao.domain.Funcionario;
import br.com.psmcompany.gestao.service.dto.AlterarFuncionarioDTO;
import org.springframework.stereotype.Component;

@Component
public class AlterarFuncionarioConverter extends AbstractConverter<AlterarFuncionarioDTO, Funcionario> {


    @Override
    public AlterarFuncionarioDTO toDto(Funcionario funcionario) {
        return AlterarFuncionarioDTO.builder()
                .funcionario_id(funcionario.getId())
                .cargo_id(funcionario.getCargo().getId())
                .nomeFuncionario(funcionario.getNomeFuncionario())
                .idade(funcionario.getIdade())
                .dataNascimento(funcionario.getDataNascimento())
                .build();
    }

    @Override
    public Funcionario toEntity(AlterarFuncionarioDTO alterarFuncionarioDTO) {
        return Funcionario.builder()
                .id(alterarFuncionarioDTO.getFuncionario_id())
                .cargo(Cargo.builder().id(alterarFuncionarioDTO.getCargo_id()).build())
                .nomeFuncionario(alterarFuncionarioDTO.getNomeFuncionario())
                .cpf(alterarFuncionarioDTO.getCpf())
                .dataNascimento(alterarFuncionarioDTO.getDataNascimento())
                .departamento(Departamento.builder().id(alterarFuncionarioDTO.getDepartamentoId()).build())
                .idade(alterarFuncionarioDTO.getIdade())
                .build();
    }
}
