package com.example.financeiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.financeiro.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
