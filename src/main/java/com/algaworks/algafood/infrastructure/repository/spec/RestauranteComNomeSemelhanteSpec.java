package com.algaworks.algafood.infrastructure.repository.spec;

import com.algaworks.algafood.domain.model.Restaurante;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serial;
import java.math.BigDecimal;

@AllArgsConstructor // cria o construtor recebendo e atribuindo a variavel de instância
public class RestauranteComNomeSemelhanteSpec implements Specification<Restaurante> {
    @Serial
    private static final long serialVersionUID = 1L;

    private String nome;

    @Override
    public Predicate toPredicate(Root<Restaurante> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        // representa um filtro onde taxaFrete é zero
        return criteriaBuilder.equal(root.get("nome"), "%" + nome + "%");
    }
}
