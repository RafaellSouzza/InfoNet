package br.com.infnet.InfoNet.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Idade é obrigatória")
    private Integer idade;

    @NotBlank(message = "Cargo é obrigatório")
    private String cargo;

    public @NotBlank(message = "Cargo é obrigatório") String getCargo() {
        return cargo;
    }

    public void setCargo(@NotBlank(message = "Cargo é obrigatório") String cargo) {
        this.cargo = cargo;
    }

    public @NotNull(message = "Idade é obrigatória") Integer getIdade() {
        return idade;
    }

    public void setIdade(@NotNull(message = "Idade é obrigatória") Integer idade) {
        this.idade = idade;
    }

    public @NotBlank(message = "Nome é obrigatório") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome é obrigatório") String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}