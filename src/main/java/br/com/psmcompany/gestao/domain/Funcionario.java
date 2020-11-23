package br.com.psmcompany.gestao.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tbl_funcionario")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome",nullable = false,length = 50)
    private String nomeFuncionario;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "dataNasc",nullable = false)
    private LocalDate dataNascimento;

    @ManyToOne()
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @ManyToOne()
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;
}
