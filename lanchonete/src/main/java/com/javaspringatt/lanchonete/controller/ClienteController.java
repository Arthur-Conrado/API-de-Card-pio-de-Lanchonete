package com.javaspringatt.lanchonete.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.javaspringatt.lanchonete.models.ModelCliente;
import com.javaspringatt.lanchonete.services.AttClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    
    @Autowired
    private AttClienteService attClienteService;

    @GetMapping
    public ResponseEntity<List<ModelCliente>> listarTodos(){
        List<ModelCliente> clientes = attClienteService.listarTodos();
        return ResponseEntity.ok(clientes);
    }  

    @GetMapping("/{id}")
    public ResponseEntity<ModelCliente> buscarPorId(@PathVariable int id){
        ModelCliente cliente = attClienteService.buscarPorId(id);
        if(cliente != null){
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<ModelCliente> buscarPorEmail(@PathVariable String email){
        Optional<ModelCliente> cliente = attClienteService.buscarPorEmail(email);
        if(cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/buscar/nome/{nome}")
    public ResponseEntity<List<ModelCliente>> buscarPorNome(@PathVariable String nome){
        List<ModelCliente> clientes = attClienteService.buscarPorNome(nome);
        if(!clientes.isEmpty()){
            return ResponseEntity.ok(clientes);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> adicionarCliente(@RequestBody ModelCliente cliente){
        try {
            ModelCliente clienteSalvo = attClienteService.adicionarCliente(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCliente(@PathVariable int id, @RequestBody ModelCliente cliente){
        try {
            ModelCliente clienteAtualizado = attClienteService.atualizarCliente(id, cliente);
            if(clienteAtualizado != null){
                return ResponseEntity.ok(clienteAtualizado);
            }
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable int id){
        ModelCliente cliente = attClienteService.buscarPorId(id);
        if(cliente != null){
            attClienteService.deletarCliente(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}