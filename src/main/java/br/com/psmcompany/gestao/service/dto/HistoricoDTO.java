package br.com.psmcompany.gestao.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoDTO {

    private Long historico_id;

    private Long funcionario_id;

    private Long departamento_id;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

}
