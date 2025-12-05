package com.javaspringatt.lanchonete.services;

@Service
public class AttPedidoService {

  private final AttPedidoRepository repo;

  public AttPedidoService(AttPedidoRepository repo) {
    this.repo = repo;
  }

  public AttPedidoModel criarPedido(AttPedidoModel pedido) {
    return repo.save(pedido);
  }

  public List<AttPedidoModel> listar() {
    return repo.findAll();
  }

  public AttPedidoModel buscar(Long id) {
    return repo.findById(id).orElse(null);
  }
}