package br.com.infnet.InfoNet.Service;

import br.com.infnet.InfoNet.Model.Produto;
import br.com.infnet.InfoNet.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Produto getProdutoById(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }

    public Produto createProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto updateProduto(Long id, Produto produto) {
        Optional<Produto> produtoExistente = produtoRepository.findById(id);
        if (produtoExistente.isPresent()) {
            Produto atualizacao = produtoExistente.get();
            atualizacao.setNome(produto.getNome());
            atualizacao.setDescricao(produto.getDescricao());
            atualizacao.setPreco(produto.getPreco());
            atualizacao.setQuantidade(produto.getQuantidade());
            return produtoRepository.save(atualizacao);
        }
        return null;
    }

    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}