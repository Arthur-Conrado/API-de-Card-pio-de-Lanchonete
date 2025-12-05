package com.javaspringatt.lanchonete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javaspringatt.lanchonete.models.ModelCliente;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ModelCliente, Integer> {
    

    Optional<ModelCliente> findByEmailAndAtivoTrue(String email);
    
 
    Optional<ModelCliente> findByEmail(String email);
    
  
    Optional<ModelCliente> findByCpf(String cpf);
    
  
    List<ModelCliente> findByAtivoTrue();
    
   
    List<ModelCliente> findByNomeCompletoContainingIgnoreCase(String nome);
}