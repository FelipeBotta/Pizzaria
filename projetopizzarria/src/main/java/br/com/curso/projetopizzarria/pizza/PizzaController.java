package br.com.curso.projetopizzarria.pizza;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
@RequiredArgsConstructor
public class PizzaController {

    private final PizzaService pizzaService;
    @PostMapping
    public void cadastrar(@RequestBody @Valid PizzaDTO dto){

        pizzaService.criarPizza(dto);
    }

    @GetMapping
    public List<PizzaDTO> buscarTodos(){

        return pizzaService.buscarTodos();

    }


    @GetMapping("/{id}")
    public PizzaDTO buscarPorId(@PathVariable Long id){

        return pizzaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public PizzaDTO atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid PizzaDTO dto){
        PizzaDTO pizzaAtualizada = pizzaService.atualizarPizza(id, dto);
        return pizzaAtualizada;
    }

}
