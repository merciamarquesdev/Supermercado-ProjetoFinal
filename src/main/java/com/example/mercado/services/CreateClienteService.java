package com.example.mercado.services;

import com.example.mercado.entity.Cliente;
import com.example.mercado.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateClienteService {
    private final ClienteRepository clienteRepository;
    public Cliente excute(Cliente cliente){
        cliente.setIdCliente(UUID.randomUUID().toString());
        log.info("Cliente de ID{}", cliente.getIdCliente());
        return clienteRepository.findById(cliente.getIdCliente()).orElse(clienteRepository.save(cliente));
    }
}
