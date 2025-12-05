package com.javaspringatt.lanchonete.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "itens_pedido")
@Getter
@Setter
public class AttItemPedidoModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "produto_id", nullable = false)
  private AttModel produto;

  @Column(nullable = false)
  private Integer quantidade;

  @Column(nullable = false)
  private Double precoUnitario;

  @ManyToOne
  @JoinColumn(name = "pedido_id")
  private AttPedidoModel pedido;
}