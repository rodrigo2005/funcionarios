package br.com.psmcompany.gestao.service.conversor;

import br.com.psmcompany.gestao.domain.Departamento;
import br.com.psmcompany.gestao.domain.Funcionario;
import br.com.psmcompany.gestao.domain.Historico;
import br.com.psmcompany.gestao.service.dto.HistoricoDTO;
import org.springframework.stereotype.Component;

@Component
public class HistoricoConverter extends AbstractConverter<HistoricoDTO, Historico> {


    @Override
    public HistoricoDTO toDto(Historico historico) {
        return HistoricoDTO.builder()
                .historico_id(historico.getId())
                .funcionario_id(historico.getFuncionario().getId())
                .departamento_id(historico.getDepartamento().getId())
                .dataInicio(historico.getDataInicio())
                .dataFim(historico.getDataFim())
                .build();
    }

    @Override
    public Historico toEntity(HistoricoDTO historicoDTO) {
        return Historico.builder()
                .id(historicoDTO.getHistorico_id())
                .funcionario(Funcionario.builder().id(historicoDTO.getFuncionario_id()).build())
                .departamento(Departamento.builder().id(historicoDTO.getDepartamento_id()).build())
                .dataInicio(historicoDTO.getDataInicio())
                .dataFim(historicoDTO.getDataFim())
                .build();
    }
}
