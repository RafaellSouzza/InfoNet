package br.com.infnet.InfoNet.Repository;

import br.com.infnet.InfoNet.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> { }
