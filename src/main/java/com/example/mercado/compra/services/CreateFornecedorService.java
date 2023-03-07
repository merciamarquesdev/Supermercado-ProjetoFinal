package com.example.mercado.compra.services;

import com.example.mercado.compra.entity.Fornecedor;
import com.example.mercado.compra.repositories.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateFornecedorService {
    private final FornecedorRepository fornecedorRepository;
    public Fornecedor excute(Fornecedor fornecedor){
        fornecedor.setIdFornecedor(UUID.randomUUID().toString());
        log.info("Fornecedor de ID{}", fornecedor.getIdFornecedor());
        return fornecedorRepository.findById(fornecedor.getIdFornecedor()).orElse(fornecedorRepository.save(fornecedor));
    }

    public Optional<Fornecedor> getById(String id) {
        var fornecedor = fornecedorRepository.findById(id);
        return fornecedor;
    }
}
