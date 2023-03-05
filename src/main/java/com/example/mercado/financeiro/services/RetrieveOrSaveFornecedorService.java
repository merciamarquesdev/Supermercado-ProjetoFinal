package com.example.mercado.financeiro.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.mercado.financeiro.entity.Fornecedor;
import com.example.mercado.financeiro.repositories.FornecedorRepository;

@Service
@RequiredArgsConstructor
public class RetrieveOrSaveFornecedorService {

    private final FornecedorRepository fornecedorRepository;

    public Fornecedor execute(Fornecedor fornecedor){
        return fornecedorRepository.findByIdentificador(fornecedor.getIdentificador())
                .orElse(fornecedorRepository.save(fornecedor));
    }
}