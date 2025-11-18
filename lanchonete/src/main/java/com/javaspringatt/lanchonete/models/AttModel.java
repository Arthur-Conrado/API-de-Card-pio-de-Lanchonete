package com.javaspringatt.lanchonete.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Cardapio")
@Getter
@Setter

public class AttModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(nullable = false, length=100)
private String nome;

@Column(nullable = false)
private String descricao;

@Column(nullable = false)
private Double preco;

@Column(nullable = false, length = 100)
private String categoria;

@Column(nullable = false)
private boolean disponivel ;

@Column(nullable = false)
private String tempoDePreparo;



public AttModel(){

}
public AttModel(int id, String nome, String descricao, double preco, String categoria,boolean disponivel,String tempoDePreparo){

    this.id=id;
    this.nome=nome;
    this.descricao=descricao;
    this.preco=preco;
    this.categoria=categoria;
    this.disponivel = disponivel;
    this.tempoDePreparo=tempoDePreparo;
}
}
