package br.com.psmcompany.gestao.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuscarFuncionarioDTO {

    private Long funcionario_id;

    private String nomeFuncionario;

    private CargoDTO cargo;



}
