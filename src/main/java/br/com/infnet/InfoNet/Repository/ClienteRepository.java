package br.com.infnet.InfoNet.Repository;

import br.com.infnet.InfoNet.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> { }
