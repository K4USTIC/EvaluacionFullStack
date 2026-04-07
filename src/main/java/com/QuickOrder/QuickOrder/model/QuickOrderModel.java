package com.QuickOrder.QuickOrder.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Data
@Entity

public class QuickOrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "el nombre no puede estar vacio")
    private String nombreCliente;

    @NotBlank (message = "la descripcion es obligatoria")
    private String descripcion;

    @NotBlank (message = "el estado es obligatorio")
    private Estado estado;

    @NotBlank (message = "el tipo de pedido es obligatorio")
    private TipoPedido tipoPedido;

    @NotNull(message = "el monto es obligatorio")
    @Positive (message = "el monto debe ser mayor a cero")
    private Double montoTotal;

    private LocalDate fechaPedido = LocalDate.now();


}
