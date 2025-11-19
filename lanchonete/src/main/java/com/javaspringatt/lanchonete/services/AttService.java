package com.javaspringatt.lanchonete.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspringatt.lanchonete.services.AttService;

import com.javaspringatt.lanchonete.models.AttModel;
import com.javaspringatt.lanchonete.repository.AttRepository;


@Service
public class AttService {

    @Autowired
    private AttRepository attRepository;
    public List<AttModel> listarTodos(){
        return attRepository.findAll();
    }
    public AttModel buscarPorId(int id){
        Optional <AttModel> cardapio = attRepository.findById(id);
        return cardapio.orElse(null);
    }

     public List<AttModel> buscarPorCategoria(String categoria) {
        return attRepository.findByCategoriaAndDisponivelTrue(categoria);
    }




    public AttModel adicionarCardapio(AttModel cardapio){
        return attRepository.save(cardapio);
    }
    public AttModel atualizarCardapio(int id, AttModel cardapioatualizado){
        Optional<AttModel> cardapioExistente = attRepository.findById(id);
        if(cardapioExistente.isPresent()){
            AttModel cardapio = cardapioExistente.get();
            cardapio.setNome(cardapioatualizado.getNome());
            cardapio.setPreco(cardapioatualizado.getPreco());
            cardapio.setDescricao(cardapioatualizado.getDescricao());
            cardapio.setCategoria(cardapioatualizado.getCategoria());
            cardapio.setTempoDePreparo(cardapioatualizado.getTempoDePreparo());
            return attRepository.save(cardapio);
        }
        return null;
    }
    public void deletarCardapio(int id){
        attRepository.deleteById(id);
        
    }
    public double calcularValorTotal(){
        List<AttModel> cardapios = attRepository.findAll();
        double total = 0;
        for (AttModel a:cardapios){
            total+=a.getPreco();
        }
        return total;
    }
   


}
