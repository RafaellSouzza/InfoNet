package br.com.infnet.InfoNet.Repository;
import br.com.infnet.InfoNet.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}