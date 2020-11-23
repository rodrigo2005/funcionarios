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
public class DefinirChefeDepartamentoDTO {

    @NotNull(message = "O departamento e de preenchimento obrigarório")
    private Long departamentoId;

    @NotNull(message = "O funcionário e de preenchimento obrigarório")
    private Long funcionarioId;


}
