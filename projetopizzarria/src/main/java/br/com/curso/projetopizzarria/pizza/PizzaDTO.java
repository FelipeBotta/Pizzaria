package br.com.curso.projetopizzarria.pizza;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PizzaDTO {
    @NotBlank
    private String nome;
    private double preco;
    private boolean disponivel;
    private Tamanho tamanho;
    private Sabor sabor;
}
