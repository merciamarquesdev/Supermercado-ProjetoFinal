package com.example.mercado.services;

import com.example.mercado.entity.Fornecedor;
import com.example.mercado.repositories.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
