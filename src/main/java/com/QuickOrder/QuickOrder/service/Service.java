package com.QuickOrder.QuickOrder.service;


import com.QuickOrder.QuickOrder.model.QuickOrderModel;
import com.QuickOrder.QuickOrder.repository.Repository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor

public class Service {
    private final Repository repository;

    public QuickOrderModel crearPedido(QuickOrderModel pedido){
        pedido.setFechaPedido(LocalDate.now());
        return repository.save(pedido);
    }

    public List<QuickOrderModel> obtenerTodosLosPedidos(){
        return repository.findAll();
    }

    public Optional<QuickOrderModel> ObtenerPedidoPorId(Long id){
        return  repository.findById(id);
    }
}
