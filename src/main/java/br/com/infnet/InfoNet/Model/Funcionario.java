package br.com.infnet.InfoNet.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Funcionario {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Cargo é obrigatório")
    private String cargo;

    @NotNull(message = "Salário é obrigatório")
    @Positive(message = "Salário deve ser positivo")
    private Double salario;

    @NotNull(message = "Idade é obrigatória")
    @Positive(message = "Idade deve ser positiva")
    private Integer idade;

    public @NotNull(message = "Idade é obrigatória") @Positive(message = "Idade deve ser positiva") Integer getIdade() {
        return idade;
    }

    public void setIdade(@NotNull(message = "Idade é obrigatória") @Positive(message = "Idade deve ser positiva") Integer idade) {
        this.idade = idade;
    }

    public @NotNull(message = "Salário é obrigatório") @Positive(message = "Salário deve ser positivo") Double getSalario() {
        return salario;
    }

    public void setSalario(@NotNull(message = "Salário é obrigatório") @Positive(message = "Salário deve ser positivo") Double salario) {
        this.salario = salario;
    }

    public @NotBlank(message = "Cargo é obrigatório") String getCargo() {
        return cargo;
    }

    public void setCargo(@NotBlank(message = "Cargo é obrigatório") String cargo) {
        this.cargo = cargo;
    }

    public @NotBlank(message = "Nome é obrigatório") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome é obrigatório") String nome) {
        this.nome = nome;
    }

}