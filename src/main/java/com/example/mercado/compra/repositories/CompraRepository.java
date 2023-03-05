package com.example.mercado.compra.repositories;

import com.example.mercado.compra.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}
