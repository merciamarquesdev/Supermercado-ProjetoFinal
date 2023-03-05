package com.example.mercado.financeiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mercado.financeiro.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
