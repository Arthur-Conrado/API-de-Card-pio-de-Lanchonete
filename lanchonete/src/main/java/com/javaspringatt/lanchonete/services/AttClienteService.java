package com.javaspringatt.lanchonete.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaspringatt.lanchonete.models.ModelCliente;
import com.javaspringatt.lanchonete.repository.ClienteRepository;


@Service
public class AttClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public List<ModelCliente> listarTodos(){
        return clienteRepository.findByAtivoTrue();
    }
    public ModelCliente buscarPorId(int id){
        Optional<ModelCliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }
    public Optional<ModelCliente> buscarPorEmail(String email){
        return clienteRepository.findByEmailAndAtivoTrue(email);
    }


     public ModelCliente adicionarCliente(ModelCliente cliente){
        cliente.setAtivo(true);
        return clienteRepository.save(cliente);
    }
    
    public ModelCliente atualizarCliente(int id, ModelCliente clienteAtualizado){
        Optional<ModelCliente> clienteExistente = clienteRepository.findById(id);
        if(clienteExistente.isPresent()){
            ModelCliente cliente = clienteExistente.get();
            
          
            cliente.setNomeCompleto(clienteAtualizado.getNomeCompleto());
            cliente.setEmail(clienteAtualizado.getEmail());
            cliente.setEndereco(clienteAtualizado.getEndereco());
            cliente.setTelefone(clienteAtualizado.getTelefone());
            cliente.setPreferencias(clienteAtualizado.getPreferencias());
            cliente.setCpf(clienteAtualizado.getCpf());
            cliente.setAtivo(clienteAtualizado.isAtivo());
            
            return clienteRepository.save(cliente);
        }
        return null;
    }

}
