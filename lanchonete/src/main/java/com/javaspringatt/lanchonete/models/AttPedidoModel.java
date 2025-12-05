package com.javaspringatt.lanchonete.models;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pedidos")
@Getter
@Setter

public class AttPedidoModel {
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

 
  @ManyToOne
  @JoinColumn(name = "cliente_id", nullable = false)
  private ModelCliente cliente;

 
  @ManyToOne
  @JoinColumn(name = "funcionario_id", nullable = false)
  private AttFuncionariosModel funcionario;

 
  @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
  private List<AttItemPedidoModel> itens;

  @Column(nullable = false)
  private LocalDateTime dataPedido;

  @Column(nullable = false)
  private Double valorTotal;

  @PrePersist
  protected void onCreate() {
    dataPedido = LocalDateTime.now();
  }
    
    
}
