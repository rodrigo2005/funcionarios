package br.com.psmcompany.gestao.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentoDTO {

    private Long departamento_id;

    @NotNull(message = "Nome de Departamento e Obrigatório")
    private String nomeDepartamento;

    private  Long funcionarioChefeId;

}
