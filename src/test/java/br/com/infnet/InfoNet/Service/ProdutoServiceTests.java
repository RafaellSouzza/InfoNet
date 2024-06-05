package br.com.infnet.InfoNet.Service;

import br.com.infnet.InfoNet.Model.Produto;
import br.com.infnet.InfoNet.Repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ProdutoServiceTests {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deveRetornarTodosOsProdutos() {
        Produto produto1 = new Produto();
        produto1.setId(1L);
        produto1.setNome("Produto 1");
        Produto produto2 = new Produto();
        produto2.setId(2L);
        produto2.setNome("Produto 2");

        when(produtoRepository.findAll()).thenReturn(Arrays.asList(produto1, produto2));

        List<Produto> produtos = produtoService.getAllProdutos();

        assertNotNull(produtos);
        assertEquals(2, produtos.size());
        verify(produtoRepository, times(1)).findAll();
    }

    @Test
    public void deveRetornarProdutoPorId() {
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setNome("Produto 1");

        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));

        Produto produtoRetornado = produtoService.getProdutoById(1L);

        assertNotNull(produtoRetornado);
        assertEquals("Produto 1", produtoRetornado.getNome());
        verify(produtoRepository, times(1)).findById(1L);
    }

    @Test
    public void deveCriarNovoProduto() {
        Produto produto = new Produto();
        produto.setNome("Produto 1");

        when(produtoRepository.save(any(Produto.class))).thenReturn(produto);

        Produto produtoCriado = produtoService.createProduto(produto);

        assertNotNull(produtoCriado);
        assertEquals("Produto 1", produtoCriado.getNome());
        verify(produtoRepository, times(1)).save(produto);
    }

    @Test
    public void deveAtualizarProduto() {
        Produto produtoExistente = new Produto();
        produtoExistente.setId(1L);
        produtoExistente.setNome("Produto 1");

        Produto produtoAtualizado = new Produto();
        produtoAtualizado.setNome("Produto Atualizado");

        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produtoExistente));
        when(produtoRepository.save(any(Produto.class))).thenReturn(produtoExistente);

        Produto produto = produtoService.updateProduto(1L, produtoAtualizado);

        assertNotNull(produto);
        assertEquals("Produto Atualizado", produto.getNome());
        verify(produtoRepository, times(1)).findById(1L);
        verify(produtoRepository, times(1)).save(produtoExistente);
    }

    @Test
    public void deveDeletarProduto() {
        Produto produto = new Produto();
        produto.setId(1L);

        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));
        doNothing().when(produtoRepository).deleteById(1L);

        produtoService.deleteProduto(1L);

        verify(produtoRepository, times(1)).deleteById(1L);
    }
}
