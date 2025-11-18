package com.javaspringatt.lanchonete.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javaspringatt.lanchonete.models.AttModel;
import com.javaspringatt.lanchonete.services.AttClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    private AttClienteService attClienteService;

@GetMapping
public ResponseEntity<List<AttModel>>listarTodos(){
    List <AttModel> clientes = attClienteService.listarTodos();
    return ResponseEntity.ok(clientes);
} 

@GetMapping("/api/clientes/{id}")
public ResponseEntity<attModel> buscarPorId(@parthVariable int id ){
    AttModel cliente = attClienteService.buscarPorId(id);
     if(cliente!=null){
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build();
}
@GetMapping("/api/email/{categoria}")
    public ResponseEntity<List<AttModel>> buscarPorEmail(@PathVariable String email){
        List<AttModel> clientes = attClienteService.buscarPorEmail(email);
        if(!clientes.isEmpty()){
            return ResponseEntity.ok(clientes);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
public ResponseEntity<AttModel> adicionarCliente(@RequestBody AttModel cliente){
    AttModel clienteSalvo = attClienteService.adicionarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
}

@PutMapping("/{id}")
public ResponseEntity<AttModel> atualizarCliente(@PathVariable int id, @RequestBody AttModel cliente){
    AttModel clienteAtualizado = attClienteService.atualizarCliente(id,cliente);
    if(clienteAtualizado!=null){
        return ResponseEntity.ok(clienteAtualizado);
    }
    return ResponseEntity.notFound().build();

}

}
