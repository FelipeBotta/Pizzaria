package br.com.curso.projetopizzarria.pizza;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PizzaService {

    private final PizzaRepository pizzaRepository;
    private final ModelMapper modelMapper;

    public PizzaDTO criarPizza(PizzaDTO dto){
        Pizza pizza = modelMapper.map(dto, Pizza.class);
        pizzaRepository.save(pizza);

        return modelMapper.map(pizza, PizzaDTO.class);

    }

    public List<PizzaDTO> buscarTodos() {
        return pizzaRepository.findAll().stream().map(p -> modelMapper.map(p, PizzaDTO.class)).collect(Collectors.toList());
    }
}
