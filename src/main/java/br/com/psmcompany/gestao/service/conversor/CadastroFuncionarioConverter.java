package br.com.psmcompany.gestao.service.conversor;

import br.com.psmcompany.gestao.domain.Cargo;
import br.com.psmcompany.gestao.domain.Departamento;
import br.com.psmcompany.gestao.domain.Funcionario;
import br.com.psmcompany.gestao.service.dto.CadastroFuncionarioDTO;
import org.springframework.stereotype.Component;

@Component
public class CadastroFuncionarioConverter extends AbstractConverter<CadastroFuncionarioDTO, Funcionario> {


    @Override
    public CadastroFuncionarioDTO toDto(Funcionario funcionario) {
        return CadastroFuncionarioDTO.builder()
                .cargo_id(funcionario.getCargo().getId())
                .nomeFuncionario(funcionario.getNomeFuncionario())
                .idade(funcionario.getIdade())
                .dataNascimento(funcionario.getDataNascimento())
                .cpf(funcionario.getCpf())
                .departamentoId(funcionario.getDepartamento().getId())
                .dataNascimento(funcionario.getDataNascimento())
                .build();
    }

    @Override
    public Funcionario toEntity(CadastroFuncionarioDTO cadastroFuncionarioDTO) {
        return Funcionario.builder()
                .cargo(Cargo.builder().id(cadastroFuncionarioDTO.getCargo_id()).build())
                .nomeFuncionario(cadastroFuncionarioDTO.getNomeFuncionario())
                .cpf(cadastroFuncionarioDTO.getCpf())
                .dataNascimento(cadastroFuncionarioDTO.getDataNascimento())
                .departamento(Departamento.builder().id(cadastroFuncionarioDTO.getDepartamentoId()).build())
                .idade(cadastroFuncionarioDTO.getIdade())
                .build();
    }
}
