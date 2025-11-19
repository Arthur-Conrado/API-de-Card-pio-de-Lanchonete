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

@GetMapping("/api/clientes/{id}")
public ResponseEntity<ModelCliente> buscarPorId(@PathVariable int id ){
    ModelCliente cliente = attClienteService.buscarPorId(id);
     if(cliente!=null){
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

    @PostMapping
    public ResponseEntity<ModelCliente> adicionarCliente(@RequestBody ModelCliente cliente){
        ModelCliente clienteSalvo = attClienteService.adicionarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
}

@PutMapping("/{id}")
public ResponseEntity<ModelCliente> atualizarCliente(@PathVariable int id, @RequestBody ModelCliente cliente){
    ModelCliente clienteAtualizado = attClienteService.atualizarCliente(id,cliente);
    if(clienteAtualizado!=null){
        return ResponseEntity.ok(clienteAtualizado);
    }
    return ResponseEntity.notFound().build();

}

}
