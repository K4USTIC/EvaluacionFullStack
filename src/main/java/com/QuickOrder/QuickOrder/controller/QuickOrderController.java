package com.QuickOrder.QuickOrder.controller;

import com.QuickOrder.QuickOrder.model.QuickOrderModel;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/pedidos")
@RestController
@RequiredArgsConstructor
public class QuickOrderController {
    private Service service;

    @PostMapping
    public ResponseEntity<QuickOrderModel> crearPedido(@Valid @RequestBody QuickOrderModel pedido){
        QuickOrderModel nuevoPedido = service.crearPedido(pedido);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QuickOrderModel>> obtenerTodos(){
        List<QuickOrderModel> pedidos = service.obtenerTodosLosPedidos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity <QuickOrderModel> obtenerPorId(@PathVariable Long id){
        return service.obtenerPedidoPorId(id)
                .map(pedido -> new ResponseEntity<>(pedido, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
