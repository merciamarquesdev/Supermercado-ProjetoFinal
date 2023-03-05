package com.example.mercado.financeiro.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.mercado.financeiro.entity.Pagamento;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    @EntityGraph(value = "Pagamento.items")
    List<Pagamento> findByFornecedorIdentificador(String identificadorFornecedor);
}