package com.algaworks.algafood.controller;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.jpa.CadastroCozinha;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/api/algafood/cozinhas")
public class CozinhaController {

    @Autowired
    CadastroCozinha cadastroCozinha;

    @GetMapping
    public ResponseEntity<List<Cozinha>> listarTodas() {
        return ResponseEntity.ok(cadastroCozinha.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cozinha> listarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cadastroCozinha.buscar(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha adicionar(@RequestBody Cozinha cozinha) {
        return cadastroCozinha.salvar(cozinha);
    }

    // ou assim:
//    @PostMapping
//    public ResponseEntity<Cozinha> adicionar(@RequestBody Cozinha cozinha){
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(cadastroCozinha.salvar(cozinha));
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Cozinha> atualizar (@PathVariable Long id, @RequestBody Cozinha cozinha) {
        Cozinha cozinhaAtual = cadastroCozinha.buscar(id);
        cozinhaAtual.setNome(cozinha.getNome());
//        BeanUtils.copyProperties(cozinha, cozinhaAtual, "id"); // alternativa
        if (cozinhaAtual != null) {
            return ResponseEntity.notFound().build();
        }
        cadastroCozinha.salvar(cozinhaAtual);

        return ResponseEntity.ok().body(cozinhaAtual);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        cadastroCozinha.remover(id);

        return ResponseEntity.noContent().build();
    }
}
