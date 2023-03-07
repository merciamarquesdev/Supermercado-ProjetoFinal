package com.example.mercado.fornecimento.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.mercado.fornecimento.entity.Fornecedor;
import com.example.mercado.fornecimento.repositories.FornecedorRepository;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateFornecedorService {

    private final FornecedorRepository fornecedorRepository;
    public Fornecedor execute(Fornecedor fornecedor){
        fornecedor.setIdentificador(UUID.randomUUID().toString());
        log.info("Fornecedor de ID {}",fornecedor.getIdentificador());
        return fornecedorRepository.findById(fornecedor.getCnpj())
                .orElse(fornecedorRepository.save(fornecedor));

    }
}