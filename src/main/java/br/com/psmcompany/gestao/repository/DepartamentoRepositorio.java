package br.com.psmcompany.gestao.repository;

import br.com.psmcompany.gestao.domain.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepositorio extends JpaRepository<Departamento, Long> {
}
