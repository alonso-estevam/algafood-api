package com.algaworks.algafood.controller;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.infrastructure.repository.spec.RestauranteComFreteGratisSpec;
import com.algaworks.algafood.infrastructure.repository.spec.RestauranteComNomeSemelhanteSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/algafood/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteRepository repository;

    @GetMapping
    public List<Restaurante> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/por-nome")
    public List<Restaurante> consultarPorNome(@RequestParam String nome, @RequestParam Long id) {
        return repository.consultarPorNomeECozinha(nome, id);
    }

    @GetMapping("/frete-gratis")
    public List<Restaurante> freteGratis(@RequestParam String nome) {
        var comFreteGratis = new RestauranteComFreteGratisSpec();
        var nomeSemelhante = new RestauranteComNomeSemelhanteSpec(nome);

        return repository.findAll(comFreteGratis.and(nomeSemelhante));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> atualizar(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        Restaurante restauranteAtual = repository.findById(id)
                .orElseThrow();
        restauranteAtual.setNome(restaurante.getNome());
        restauranteAtual.setCozinha(restaurante.getCozinha());
        restauranteAtual.setTaxaFrete(restaurante.getTaxaFrete());

        return ResponseEntity.ok().body(repository.save(restauranteAtual));

    }

}
