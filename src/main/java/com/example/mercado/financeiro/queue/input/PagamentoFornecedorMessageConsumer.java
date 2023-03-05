package com.example.mercado.financeiro.queue.input;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.example.mercado.financeiro.payload.request.PagamentoFornecedorRequest;
import com.example.mercado.financeiro.services.SalvarPagamentoService;

@Component
@RequiredArgsConstructor
public class PagamentoFornecedorMessageConsumer {
    private final ObjectMapper objectMapper;
    private final SalvarPagamentoService pagamentoService;
    @RabbitListener(queues = {"${business.message.queue.pagamento_fornecedor}"})
    public void receiveMessage(String message) throws JsonProcessingException {
        PagamentoFornecedorRequest pagamentoFornecedorRequest = objectMapper.readValue(message, PagamentoFornecedorRequest.class);
        pagamentoService.execute(pagamentoFornecedorRequest);
    }
}