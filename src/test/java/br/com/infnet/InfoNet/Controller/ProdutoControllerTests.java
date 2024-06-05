package br.com.infnet.InfoNet.Controller;

import br.com.infnet.InfoNet.Model.Produto;
import br.com.infnet.InfoNet.Service.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ProdutoService produtoService;

    @InjectMocks
    private ProdutoController produtoController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        // Manualmente injetar o mock do serviço no controlador
        mockMvc = MockMvcBuilders.standaloneSetup(produtoController).build();
    }

    @Test
    public void deveRetornarListaDeProdutos() throws Exception {
        Produto produto1 = new Produto();
        produto1.setId(1L);
        produto1.setNome("Produto 1");
        Produto produto2 = new Produto();
        produto2.setId(2L);
        produto2.setNome("Produto 2");

        when(produtoService.getAllProdutos()).thenReturn(Arrays.asList(produto1, produto2));

        mockMvc.perform(get("/produtos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nome").value("Produto 1"))
                .andExpect(jsonPath("$[1].nome").value("Produto 2"));

        verify(produtoService, times(1)).getAllProdutos();
    }

    @Test
    public void deveCriarNovoProduto() throws Exception {
        Produto produto = new Produto();
        produto.setNome("Produto 1");

        when(produtoService.createProduto(any(Produto.class))).thenReturn(produto);

        String novoProduto = "{\"nome\": \"Produto 1\", \"descricao\": \"Descricao do Produto 1\", \"preco\": 10.0, \"quantidade\": 5}";

        mockMvc.perform(post("/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(novoProduto))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Produto 1"));

        verify(produtoService, times(1)).createProduto(any(Produto.class));
    }

    @Test
    public void deveRetornarProdutoPorId() throws Exception {
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setNome("Produto 1");

        when(produtoService.getProdutoById(1L)).thenReturn(produto);

        mockMvc.perform(get("/produtos/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nome").value("Produto 1"));

        verify(produtoService, times(1)).getProdutoById(1L);
    }

    @Test
    public void deveAtualizarProduto() throws Exception {
        Produto produtoAtualizado = new Produto();
        produtoAtualizado.setId(1L);
        produtoAtualizado.setNome("Produto Atualizado");

        when(produtoService.updateProduto(eq(1L), any(Produto.class))).thenReturn(produtoAtualizado);

        String produtoJson = "{\"nome\": \"Produto Atualizado\", \"descricao\": \"Descricao Atualizada\", \"preco\": 20.0, \"quantidade\": 10}";

        mockMvc.perform(put("/produtos/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(produtoJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Produto Atualizado"));

        verify(produtoService, times(1)).updateProduto(eq(1L), any(Produto.class));
    }

    @Test
    public void deveDeletarProduto() throws Exception {
        doNothing().when(produtoService).deleteProduto(1L);

        mockMvc.perform(delete("/produtos/{id}", 1))
                .andExpect(status().isNoContent());

        verify(produtoService, times(1)).deleteProduto(1L);
    }
}
