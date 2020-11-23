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
public class CargoDTO {

    private Long cargo_id;

    @NotNull(message = "Nome de Cargo e Obrigatório")
    private String nomeCargo;
}
