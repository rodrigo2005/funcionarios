package br.com.psmcompany.gestao.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_departamento")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome",nullable = false,length = 50)
    private String nomeDepartamento;

    @OneToOne()
    @JoinColumn(name = "funcionario_id")
    private  Funcionario chefeDepartamento;

    public void definirChefe(Long id){
        this.chefeDepartamento = Funcionario.builder().id(id).build();
    }

}
