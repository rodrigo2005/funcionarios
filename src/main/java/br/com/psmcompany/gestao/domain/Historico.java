package br.com.psmcompany.gestao.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_historico")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @ManyToOne()
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    public void fecharHistorico(){
        this.dataFim = LocalDateTime.now();
    }
}
