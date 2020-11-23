package br.com.psmcompany.gestao.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlterarFuncionarioDTO {

    private Long funcionario_id;

    private String nomeFuncionario;

    @Min(value = 18, message = "Idade não pode ser menor que 18")
    @Max(value = 100, message = "Idade não pode ser maior que 100")
    private Integer idade;

    @Past(message = "A Data de nascimento deve ser menor que a data de Hoje")
    private LocalDate dataNascimento;

    private String cpf;

    private Long departamentoId;

    @NotNull(message = "O Cargo e Obrigatório")
    private Long cargo_id;

}
