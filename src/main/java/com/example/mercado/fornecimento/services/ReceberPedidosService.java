package com.example.mercado.fornecimento.services;

import lombok.RequiredArgsConstructor;
import com.example.mercado.fornecimento.client.FinanceiroClient;
import com.example.mercado.fornecimento.client.payload.request.FornecedorFinanceiroRequest;
import com.example.mercado.fornecimento.client.payload.request.ItemRequest;
import com.example.mercado.fornecimento.client.payload.request.ProdutoRequest;
import com.example.mercado.fornecimento.client.payload.request.RealizarPagamentoFinanceiro;
import com.example.mercado.fornecimento.entity.Fornecedor;
import com.example.mercado.fornecimento.entity.ItemPedido;
import com.example.mercado.fornecimento.entity.Pedido;
import com.example.mercado.fornecimento.entity.Produto;
import com.example.mercado.fornecimento.jms.out.PagamentoFornecedorFinanceiroProducer;
import com.example.mercado.fornecimento.payload.PedidoRequest;
import com.example.mercado.fornecimento.queue.out.PagarFornecedorMessageSender;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceberPedidosService {
    private final FinanceiroClient financeiroClient;
    private final CreateFornecedorService createFornecedorService;

    private final CreateOrRetrieveProdutoService createOrRetrieveProdutoService;

    private final CreatePedidoService createPedidoService;

    private final PagamentoFornecedorFinanceiroProducer pagamentoFornecedorFinanceiroProducer;
    private final PagarFornecedorMessageSender pagarFornecedorMessageSender;

    public void execute(PedidoRequest pedidoRequest){

        Fornecedor fornecedor =  saveFornecedor(pedidoRequest);
        Produto produto =  saveProduto(pedidoRequest);
        Pedido pedido = savePedido(pedidoRequest, produto, fornecedor);

        sendPedidoToFinanceiro(fornecedor, produto, pedido);
    }

    private void sendPedidoToFinanceiro(Fornecedor fornecedor, Produto produto, Pedido pedido) {
        RealizarPagamentoFinanceiro realizarPagamentoFinanceiro=
                new RealizarPagamentoFinanceiro();

        FornecedorFinanceiroRequest fornecedorFinanceiroRequest = new FornecedorFinanceiroRequest();
        fornecedorFinanceiroRequest.setNomeFornecedor(fornecedorFinanceiroRequest.getNomeFornecedor());
        fornecedorFinanceiroRequest.setCnpj(fornecedor.getCnpj());
        fornecedorFinanceiroRequest.setIdentificador(fornecedor.getIdentificador());
        realizarPagamentoFinanceiro.setFornecedor(fornecedorFinanceiroRequest);

        ItemRequest itemRequest = new ItemRequest();
        itemRequest.setPreco(pedido.getItemPedidoList().iterator().next().getPreco());
        itemRequest.setQuantidade(((Double) pedido.getItemPedidoList()
                .iterator().next().getQuantidade()).intValue());

        ProdutoRequest produtoRequest = new ProdutoRequest();
        produtoRequest.setNome(produto.getNome());
        produtoRequest.setIdentificador(produto.getIdentificador());


        itemRequest.setProduto(produtoRequest);
        realizarPagamentoFinanceiro.setItems(List.of(itemRequest));

        //financeiroClient.realizarPagamento(realizarPagamentoFinanceiro);
        //pagarFornecedorMessageSender.send(realizarPagamentoFinanceiro);
        pagamentoFornecedorFinanceiroProducer.send(realizarPagamentoFinanceiro);
    }

    private Pedido savePedido(PedidoRequest pedidoRequest, Produto produto, Fornecedor fornecedor) {
        Pedido pedido = new Pedido();
        pedido.setFornecedor(fornecedor);


        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setQuantidade(pedidoRequest.getQuantidade());
        itemPedido.setPreco(pedidoRequest.getPrecoCompra());
        itemPedido.setProduto(produto);
        return createPedidoService.execute(pedido, List.of(itemPedido));


    }

    private Produto saveProduto(PedidoRequest pedidoRequest) {
        Produto produto = new Produto();
        produto.setQuantidade(pedidoRequest.getUnidadeQuantidade());
        produto.setMarca(pedidoRequest.getMarca());
        produto.setNome(pedidoRequest.getNome());
        produto.setUnidade(pedidoRequest.getUnidade());
        return createOrRetrieveProdutoService.execute(produto);
    }

    private Fornecedor saveFornecedor(PedidoRequest pedidoRequest) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(pedidoRequest.getFornecedor().getNome());
        fornecedor.setCnpj(pedidoRequest.getFornecedor().getCnpj());
        return createFornecedorService.execute(fornecedor);
    }
}