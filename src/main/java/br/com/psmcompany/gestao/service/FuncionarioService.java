package br.com.psmcompany.gestao.service;

import br.com.psmcompany.gestao.domain.Funcionario;
import br.com.psmcompany.gestao.repository.FuncionarioRepositorio;
import br.com.psmcompany.gestao.service.conversor.AlterarFuncionarioConverter;
import br.com.psmcompany.gestao.service.conversor.BuscarFuncionarioConverter;
import br.com.psmcompany.gestao.service.conversor.CadastroFuncionarioConverter;
import br.com.psmcompany.gestao.service.dto.AlterarFuncionarioDTO;
import br.com.psmcompany.gestao.service.dto.BuscarFuncionarioDTO;
import br.com.psmcompany.gestao.service.dto.CadastroFuncionarioDTO;
import br.com.psmcompany.gestao.service.dto.HistoricoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class FuncionarioService {

    private FuncionarioRepositorio funcionarioRepositorio;
    private  HistoricoService historicoService;
    private CadastroFuncionarioConverter cadastroFuncionarioConverter;
    private AlterarFuncionarioConverter alterarFuncionarioConverter;
    private BuscarFuncionarioConverter buscarFuncionarioConverter;

    @Transactional
    public CadastroFuncionarioDTO criar(CadastroFuncionarioDTO cadastroFuncionarioDTO){
        Funcionario funcionario = funcionarioRepositorio.save(cadastroFuncionarioConverter.toEntity(cadastroFuncionarioDTO));
        criarHistoricoNovo(funcionario);
        return cadastroFuncionarioConverter.toDto(funcionario);
    }

    @Transactional
    public AlterarFuncionarioDTO alterar(AlterarFuncionarioDTO alterarFuncionarioDTO){
        Funcionario funcionario = funcionarioRepositorio.save(alterarFuncionarioConverter.toEntity(alterarFuncionarioDTO));
        incrementarProximoHistorico(funcionario);
        return alterarFuncionarioConverter.toDto(funcionario);
    }

    @Transactional
    public void deletar(Long id){
        funcionarioRepositorio.deleteById(id);
    }

    public BuscarFuncionarioDTO buscarPorId(Long id){
        return buscarFuncionarioConverter.toDto(
                funcionarioRepositorio.findById(id).orElseThrow(() ->
                        new IllegalArgumentException("Não existe funcionario com o ID informado.")));
    }

    public List<BuscarFuncionarioDTO> buscarPorTodos(){
        return buscarFuncionarioConverter.toDto(funcionarioRepositorio.findAll());
    }

    public List<BuscarFuncionarioDTO> buscarPorDepartamento(Long idDepartamento){
        return buscarFuncionarioConverter.toDto(funcionarioRepositorio.findByDepartamentoId(idDepartamento));
    }

    private void criarHistoricoNovo(Funcionario funcionario){
      HistoricoDTO historicoDTO =  HistoricoDTO.builder()
                .funcionario_id(funcionario.getId())
                .departamento_id(funcionario.getDepartamento().getId())
                .dataInicio(LocalDateTime.now())
                .build();
        historicoService.criar(historicoDTO);
    }

    private void incrementarProximoHistorico(Funcionario funcionario){
        HistoricoDTO historicoDTO =  HistoricoDTO.builder()
                .funcionario_id(funcionario.getId())
                .departamento_id(funcionario.getDepartamento().getId())
                .dataInicio(LocalDateTime.now())
                .build();
        historicoService.incrementarProximoHistorico(historicoDTO);
    }

}
