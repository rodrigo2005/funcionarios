package br.com.psmcompany.gestao.repository;


import br.com.psmcompany.gestao.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findByDepartamentoId(Long idDepartamento);
}
