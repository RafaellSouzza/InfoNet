package br.com.infnet.InfoNet.Controller;

import br.com.infnet.InfoNet.Model.Funcionario;
import br.com.infnet.InfoNet.Service.FuncionarioService;
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
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FuncionarioControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private FuncionarioService funcionarioService;

    @InjectMocks
    private FuncionarioController funcionarioController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(funcionarioController).build();
    }

    @Test
    public void deveRetornarListaDeFuncionarios() throws Exception {
        Funcionario funcionario1 = new Funcionario();
        funcionario1.setId(1L);
        funcionario1.setNome("Funcionario 1");
        Funcionario funcionario2 = new Funcionario();
        funcionario2.setId(2L);
        funcionario2.setNome("Funcionario 2");

        when(funcionarioService.getAllFuncionarios()).thenReturn(Arrays.asList(funcionario1, funcionario2));

        mockMvc.perform(get("/funcionarios"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nome").value("Funcionario 1"))
                .andExpect(jsonPath("$[1].nome").value("Funcionario 2"));

        verify(funcionarioService, times(1)).getAllFuncionarios();
    }

    @Test
    public void deveCriarNovoFuncionario() throws Exception {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Funcionario 1");

        when(funcionarioService.createFuncionario(any(Funcionario.class))).thenReturn(funcionario);

        String novoFuncionario = "{\"nome\": \"Funcionario 1\", \"cargo\": \"Desenvolvedor\", \"salario\": 5000.0}";

        mockMvc.perform(post("/funcionarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(novoFuncionario))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Funcionario 1"));

        verify(funcionarioService, times(1)).createFuncionario(any(Funcionario.class));
    }

    @Test
    public void deveRetornarFuncionarioPorId() throws Exception {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(1L);
        funcionario.setNome("Funcionario 1");

        when(funcionarioService.getFuncionarioById(1L)).thenReturn(funcionario);

        mockMvc.perform(get("/funcionarios/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nome").value("Funcionario 1"));

        verify(funcionarioService, times(1)).getFuncionarioById(1L);
    }

    @Test
    public void deveAtualizarFuncionario() throws Exception {
        Funcionario funcionarioAtualizado = new Funcionario();
        funcionarioAtualizado.setId(1L);
        funcionarioAtualizado.setNome("Funcionario Atualizado");

        when(funcionarioService.updateFuncionario(eq(1L), any(Funcionario.class))).thenReturn(funcionarioAtualizado);

        String funcionarioJson = "{\"nome\": \"Funcionario Atualizado\", \"cargo\": \"Desenvolvedor Senior\", \"salario\": 7000.0}";

        mockMvc.perform(put("/funcionarios/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(funcionarioJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Funcionario Atualizado"));

        verify(funcionarioService, times(1)).updateFuncionario(eq(1L), any(Funcionario.class));
    }

    @Test
    public void deveDeletarFuncionario() throws Exception {
        doNothing().when(funcionarioService).deleteFuncionario(1L);

        mockMvc.perform(delete("/funcionarios/{id}", 1))
                .andExpect(status().isNoContent());

        verify(funcionarioService, times(1)).deleteFuncionario(1L);
    }
}
