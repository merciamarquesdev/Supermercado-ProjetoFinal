package com.ada.mercado.repositories;

import com.ada.mercado.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}
