package com.javaspringatt.lanchonete.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspringatt.lanchonete.models.AttModel;

@RestController
@RequestMapping("/api/cardapio")
public class AttController {
        @Autowired
        private AttService attservice;
    
public ResponseEntity<List<AttModel>>listarTodos(){
    List <AttModel> cardapios = attService.listarTodos();
    return ResponseEntity.ok(cardapios);
}
public ResponseEntity<AttModel> buscarPorId(@PathVariable int id){
    AttModel cardapio = attService.buscarPorId(id);
        if(cardapio!=null){
            return ResponseEntity.ok(cardapio);
        }
        return ResponseEntity.notFound().build();
}

public ResponseEntity<AttModel> buscarPorCategoria(PathVariable String categoria){
    AttModel cardapio = attService.buscarPorCategoria(Categoria);
    if(cardapio!=null){
            return ResponseEntity.ok(cardapio);
        }
        return ResponseEntity.notFound().build();   
}

public ResponseEntity<AttModel> adicionarCardapio(@RequestBody AttModel cardapio){
    AttModel cardapioSalvo = attService.adicionarCardapio(cardapio);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardapioSalvo);
}

public ResponseEntity<AttModel> atualizarCardapio(@PathVariable int id, @RequestBody AttModel cardapio){
    AttModel cardapioAtualizado = attService.atualizarCardapio(id.cardapio);
    if(cardapioAtualizado!=null){
        return ResponseEntity.ok(cardapioAtualizado);
    }
    return ResponseEntity.notFound().build();

}

@DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCardapio(@PathVariable int id){
        AttModel cardapio = attService.buscarPorId(id);
        if(cardapio!= null){
            attservice.deletarCardapio(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Double> calcularTotal(){
        double total = attService.calcularValorTotal();
        return ResponseEntity.ok(total);
    }


}
