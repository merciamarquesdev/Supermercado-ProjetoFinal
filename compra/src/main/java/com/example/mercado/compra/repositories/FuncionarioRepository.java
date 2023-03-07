package com.example.mercado.compra.repositories;

import com.example.mercado.compra.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {
    Optional<Funcionario> findByNomeFuncionario(String nome);
}
