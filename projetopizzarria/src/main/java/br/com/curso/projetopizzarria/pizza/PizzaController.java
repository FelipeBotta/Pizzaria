package br.com.curso.projetopizzarria.pizza;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
@RequiredArgsConstructor
public class PizzaController {

    private final PizzaService pizzaService;
    @PostMapping
    public void cadastrar(@RequestBody PizzaDTO dto){
        pizzaService.criarPizza(dto);
    }

    @GetMapping
    public List<PizzaDTO> buscarTodos(){
        return pizzaService.buscarTodos();

    }

}
