package br.com.psmcompany.gestao.service;

import br.com.psmcompany.gestao.domain.Historico;
import br.com.psmcompany.gestao.repository.HistoricoRepositorio;
import br.com.psmcompany.gestao.service.conversor.HistoricoConverter;
import br.com.psmcompany.gestao.service.dto.HistoricoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HistoricoService {

    private HistoricoRepositorio historicoRepositorio;
    private HistoricoConverter historicoConverter;

    public void criar(HistoricoDTO historicoDTO){
        Historico historico = historicoConverter.toEntity(historicoDTO);
        historicoRepositorio.save(historico);
    }

    public void incrementarProximoHistorico(HistoricoDTO historicoDTO){
        Historico historico = historicoConverter.toEntity(historicoDTO);
        Historico historicoExistente = historicoRepositorio.findByFuncionarioAndDataFimNull(historico.getFuncionario().getId());
        historicoExistente.fecharHistorico();
        historicoRepositorio.save(historico);
    }


}
