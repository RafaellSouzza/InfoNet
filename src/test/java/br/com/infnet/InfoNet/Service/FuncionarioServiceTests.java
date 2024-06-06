package br.com.infnet.InfoNet.Service;

import br.com.infnet.InfoNet.Model.Funcionario;
import br.com.infnet.InfoNet.Repository.FuncionarioRepository;
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

public class FuncionarioServiceTests {

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @InjectMocks
    private FuncionarioService funcionarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deveRetornarTodosOsFuncionarios() {
        Funcionario funcionario1 = new Funcionario();
        funcionario1.setId(1L);
        funcionario1.setNome("Funcionario 1");
        Funcionario funcionario2 = new Funcionario();
        funcionario2.setId(2L);
        funcionario2.setNome("Funcionario 2");

        when(funcionarioRepository.findAll()).thenReturn(Arrays.asList(funcionario1, funcionario2));

        List<Funcionario> funcionarios = funcionarioService.getAllFuncionarios();

        assertNotNull(funcionarios);
        assertEquals(2, funcionarios.size());
        verify(funcionarioRepository, times(1)).findAll();
    }

    @Test
    public void deveRetornarFuncionarioPorId() {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(1L);
        funcionario.setNome("Funcionario 1");

        when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(funcionario));

        Funcionario funcionarioRetornado = funcionarioService.getFuncionarioById(1L);

        assertNotNull(funcionarioRetornado);
        assertEquals("Funcionario 1", funcionarioRetornado.getNome());
        verify(funcionarioRepository, times(1)).findById(1L);
    }

    @Test
    public void deveCriarNovoFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Funcionario 1");

        when(funcionarioRepository.save(any(Funcionario.class))).thenReturn(funcionario);

        Funcionario funcionarioCriado = funcionarioService.createFuncionario(funcionario);

        assertNotNull(funcionarioCriado);
        assertEquals("Funcionario 1", funcionarioCriado.getNome());
        verify(funcionarioRepository, times(1)).save(funcionario);
    }

    @Test
    public void deveAtualizarFuncionario() {
        Funcionario funcionarioExistente = new Funcionario();
        funcionarioExistente.setId(1L);
        funcionarioExistente.setNome("Funcionario 1");

        Funcionario funcionarioAtualizado = new Funcionario();
        funcionarioAtualizado.setNome("Funcionario Atualizado");

        when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(funcionarioExistente));
        when(funcionarioRepository.save(any(Funcionario.class))).thenReturn(funcionarioExistente);

        Funcionario funcionario = funcionarioService.updateFuncionario(1L, funcionarioAtualizado);

        assertNotNull(funcionario);
        assertEquals("Funcionario Atualizado", funcionario.getNome());
        verify(funcionarioRepository, times(1)).findById(1L);
        verify(funcionarioRepository, times(1)).save(funcionarioExistente);
    }

    @Test
    public void deveDeletarFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(1L);

        when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(funcionario));
        doNothing().when(funcionarioRepository).deleteById(1L);

        funcionarioService.deleteFuncionario(1L);

        verify(funcionarioRepository, times(1)).deleteById(1L);
    }
}
