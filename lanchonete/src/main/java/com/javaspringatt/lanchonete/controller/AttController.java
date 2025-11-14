package com.javaspringatt.lanchonete.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javaspringatt.lanchonete.models.AttModel;
import com.javaspringatt.lanchonete.services.AttService;

@RestController
@RequestMapping("/api/cardapio")
public class AttController {
        @Autowired
        private AttService attService;

@GetMapping
public ResponseEntity<List<AttModel>>listarTodos(){
    List <AttModel> cardapios = attService.listarTodos();
    return ResponseEntity.ok(cardapios);
}

@GetMapping("/{id}")
public ResponseEntity<AttModel> buscarPorId(@PathVariable int id){
    AttModel cardapio = attService.buscarPorId(id);
        if(cardapio!=null){
            return ResponseEntity.ok(cardapio);
        }
        return ResponseEntity.notFound().build();
}

@GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<AttModel>> buscarPorCategoria(@PathVariable String categoria){
        List<AttModel> cardapios = attService.buscarPorCategoria(categoria);
        if(!cardapios.isEmpty()){
            return ResponseEntity.ok(cardapios);
        }
        return ResponseEntity.notFound().build();
    }


@PostMapping
public ResponseEntity<AttModel> adicionarCardapio(@RequestBody AttModel cardapio){
    AttModel cardapioSalvo = attService.adicionarCardapio(cardapio);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardapioSalvo);
}

@PutMapping("/{id}")
public ResponseEntity<AttModel> atualizarCardapio(@PathVariable int id, @RequestBody AttModel cardapio){
    AttModel cardapioAtualizado = attService.atualizarCardapio(id,cardapio);
    if(cardapioAtualizado!=null){
        return ResponseEntity.ok(cardapioAtualizado);
    }
    return ResponseEntity.notFound().build();

}

@DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCardapio(@PathVariable int id){
        AttModel cardapio = attService.buscarPorId(id);
        if(cardapio!= null){
            attService.deletarCardapio(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

@GetMapping("/total")
    public ResponseEntity<Double> calcularTotal(){
        double total = attService.calcularValorTotal();
        return ResponseEntity.ok(total);
    }


}
