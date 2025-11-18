package com.javaspringatt.lanchonete.models;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Cliente")
@Getter
@Setter
public class ModelCliente {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(nullable = false,length=100)
private String nome;

@Column(nullable = false,length=100)
private String email;

@Column(nullable = false,length=100)
private String endereco;

@CreationTimestamp
private LocalDateTime dataCadastro;

@Column(nullable = false)
private boolean ativo ;

@Column(nullable = false,length=100)
private String preferencias;

@Column(nullable = false,length=100)
private String historicoCompras;

@Column(nullable = false,length=100)
private String cpf;

@Column(nullable = false,length=100)
private String pedidos;

public ModelCliente(){

}
public ModelCliente(int id, String nome,String email,String endereco, LocalDateTime dataCadastro, boolean ativo, String preferencias, String historicoCompras, String cpf, String pedidos){

    this.id = id;
    this.nome=nome;
    this.email=email;
    this.endereco=endereco;
    this.dataCadastro=dataCadastro;
    this.ativo=ativo;
    this.preferencias=preferencias;
    this.historicoCompras=historicoCompras;
    this.cpf=cpf;
    this.pedidos=pedidos;
}
}
