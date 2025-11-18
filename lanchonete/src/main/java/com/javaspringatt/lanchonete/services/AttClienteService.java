package com.javaspringatt.lanchonete.services;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspringatt.lanchonete.services.AttClienteService;
import com.javaspringatt.lanchonete.models.AttModel;
import com.javaspringatt.lanchonete.models.ModelCliente;
import com.javaspringatt.lanchonete.repository.AttRepository;


@Service
public class AttClienteService {
    @Autowired
    private AttRepository attClienteRepository;
    public List<AttModel> listarTodos(){
        return attClienteRepository.findAll();
    }
    public ModelCliente buscarPorId(id id){
        Optional<ModelCliente> cliente = attClienteRepository.findById(id);
        return cliente.orElse(null);
    }
    public ModelCliente buscarEmail(){

    }

    public ModelCliente adcionarCliente(){

    }
    
    public ModelCliente atualizarCliente(){
        
    }

}
