package br.com.infnet.InfoNet.Repository;

import br.com.infnet.InfoNet.Model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> { }
