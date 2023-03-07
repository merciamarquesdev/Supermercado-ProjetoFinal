package com.example.mercado.compra.repositories;

import com.example.mercado.compra.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
