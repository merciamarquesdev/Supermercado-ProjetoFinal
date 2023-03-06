package com.example.financeiro.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.financeiro.entity.Fornecedor;
import com.example.financeiro.repositories.FornecedorRepository;

@Service
@RequiredArgsConstructor
public class RetrieveOrSaveFornecedorService {

    private final FornecedorRepository fornecedorRepository;

    public Fornecedor execute(Fornecedor fornecedor){
        return fornecedorRepository.findByIdentificador(fornecedor.getIdentificador())
                .orElse(fornecedorRepository.save(fornecedor));
    }
}