package br.com.psmcompany.gestao.repository;

import br.com.psmcompany.gestao.domain.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HistoricoRepositorio extends JpaRepository<Historico,Long> {

    @Query("select h from Historico h where h.funcionario.id = ?1 and h.dataFim is Null")
   Historico findByFuncionarioAndDataFimNull(Long id);

}
