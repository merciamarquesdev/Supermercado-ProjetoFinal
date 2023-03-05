package com.example.mercado.compra.services;

import com.example.mercado.compra.entity.Funcionario;
import com.example.mercado.compra.repositories.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateFuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    public Funcionario execute(Funcionario funcionario){
        funcionario.setIdFuncionario(UUID.randomUUID().toString());
        log.info("Funcionario de ID {}", funcionario.getIdFuncionario());
        return funcionarioRepository.findById(funcionario.getIdFuncionario()).orElse(funcionarioRepository.save(funcionario));
    }
    public Optional<Funcionario> getById(String id) {
        var funcionario = funcionarioRepository.findById(id);
        return funcionario;
    }
}
