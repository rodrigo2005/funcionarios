package br.com.psmcompany.gestao.service;

import br.com.psmcompany.gestao.domain.Departamento;
import br.com.psmcompany.gestao.repository.DepartamentoRepositorio;
import br.com.psmcompany.gestao.service.dto.DefinirChefeDepartamentoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DepartamentoService {

    private DepartamentoRepositorio departamentoRepositorio;

    @Transactional
    public void definirChefe(DefinirChefeDepartamentoDTO alterarChefeDepartamentoDTO){
         Departamento departamento = departamentoRepositorio.findById(alterarChefeDepartamentoDTO.getDepartamentoId()).orElseThrow(() ->
                    new IllegalArgumentException("Não existe departamento com o ID informado."));
         departamento.definirChefe(alterarChefeDepartamentoDTO.getFuncionarioId());
    }

}
