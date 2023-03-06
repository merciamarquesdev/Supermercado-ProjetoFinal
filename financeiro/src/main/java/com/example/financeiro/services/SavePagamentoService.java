package com.example.financeiro.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.financeiro.entity.Pagamento;
import com.example.financeiro.repositories.PagamentoRepository;

@Service
@RequiredArgsConstructor
public class SavePagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public Pagamento executar(Pagamento pagamento){
        return pagamentoRepository.save(pagamento);
    }
}