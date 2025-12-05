package com.javaspringatt.lanchonete.services;

import org.springframework.stereotype.Service;
import java.util.List;
import com.javaspringatt.lanchonete.repository.AttPedidoRepository;
import com.javaspringatt.lanchonete.models.AttPedidoModel;

@Service
public class AttPedidoService {

  private final AttPedidoRepository repository;

  public AttPedidoService(AttPedidoRepository repository) {
    this.repository = repository;
  }

  public AttPedidoModel criarPedido(AttPedidoModel pedido) {
    return repository.save(pedido);
  }

  public List<AttPedidoModel> listar() {
    return repository.findAll();
  }

  public AttPedidoModel buscar(Long id) {
    return repository.findById(id).orElse(null);
  }
}