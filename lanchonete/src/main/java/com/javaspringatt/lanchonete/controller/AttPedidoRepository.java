package com.javaspringatt.lanchonete.services;

import org.springframework.stereotype.Service;
import java.util.List;
import com.javaspringatt.lanchonete.repository.AttPedidoRepository;
import com.javaspringatt.lanchonete.models.AttPedidoModel;

@Service
public class AttPedidoService {

    private final AttPedidoRepository attPedidoRepository;

    public AttPedidoService(AttPedidoRepository attPedidoRepository) {
        this.attPedidoRepository = attPedidoRepository;
    }

    public List<AttPedidoModel> findAll() {
        return attPedidoRepository.findAll();
    }

    public AttPedidoModel findById(Long id) {
        return attPedidoRepository.findById(id).orElse(null);
    }

    public AttPedidoModel save(AttPedidoModel attPedido) {
        return attPedidoRepository.save(attPedido);
    }

    public void deleteById(Long id) {
        attPedidoRepository.deleteById(id);
    }
}