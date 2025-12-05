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
    
    public List<ModelCliente> buscarPorNome(String nome){
        return clienteRepository.findByNomeCompletoContainingIgnoreCase(nome);
    }

    public ModelCliente adicionarCliente(ModelCliente cliente){
    
        if (clienteRepository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email já cadastrado");
        }
        
        
        if (clienteRepository.findByCpf(cliente.getCpf()).isPresent()) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }
        
        cliente.setAtivo(true);
        return clienteRepository.save(cliente);
    }
    
    public ModelCliente atualizarCliente(int id, ModelCliente clienteAtualizado){
        Optional<ModelCliente> clienteExistente = clienteRepository.findById(id);
        if(clienteExistente.isPresent()){
            ModelCliente cliente = clienteExistente.get();
            
            
            if (!cliente.getEmail().equals(clienteAtualizado.getEmail())) {
                Optional<ModelCliente> clienteComMesmoEmail = clienteRepository
                    .findByEmail(clienteAtualizado.getEmail());
                if (clienteComMesmoEmail.isPresent() && 
                    clienteComMesmoEmail.get().getId() != id) {
                    throw new IllegalArgumentException("Email já cadastrado em outro cliente");
                }
            }
            
           
            if (!cliente.getCpf().equals(clienteAtualizado.getCpf())) {
                Optional<ModelCliente> clienteComMesmoCpf = clienteRepository
                    .findByCpf(clienteAtualizado.getCpf());
                if (clienteComMesmoCpf.isPresent() && 
                    clienteComMesmoCpf.get().getId() != id) {
                    throw new IllegalArgumentException("CPF já cadastrado em outro cliente");
                }
            }
            
            cliente.setNomeCompleto(clienteAtualizado.getNomeCompleto());
            cliente.setEmail(clienteAtualizado.getEmail());
            cliente.setTelefone(clienteAtualizado.getTelefone());
            cliente.setEndereco(clienteAtualizado.getEndereco());
            cliente.setPreferencias(clienteAtualizado.getPreferencias());
            cliente.setCpf(clienteAtualizado.getCpf());
            cliente.setAtivo(clienteAtualizado.isAtivo());
            
            return clienteRepository.save(cliente);
        }
        return null;
    }
    
    public void deletarCliente(int id){
        clienteRepository.deleteById(id);
    }
}