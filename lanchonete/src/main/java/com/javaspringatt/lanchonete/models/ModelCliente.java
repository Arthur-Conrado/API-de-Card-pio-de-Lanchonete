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
@Table(name = "cliente")
@Getter
@Setter
public class ModelCliente {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(nullable = false,length=100)
private String nomeCompleto;

@Column(nullable = false,length=100, unique = true)
private String email;

@Column(length=20)
private String telefone;

@Column(nullable = false,length=100)
private String endereco;

@CreationTimestamp
private LocalDateTime dataCadastro;

@Column(nullable = false)
private boolean ativo = true;

@Column(length=200)
private String preferencias;

@Column(length=200)
private String historicoCompras;

@Column(nullable = false,length=14, unique = true)
private String cpf;

@Column(length=100)
private String pedidos;

public ModelCliente(){

}
public ModelCliente(int id, String nomeCompleto, String email, String telefone, String endereco, boolean ativo, String preferencias, String historicoCompras, String cpf, String pedidos) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.ativo = ativo;
        this.preferencias = preferencias;
        this.historicoCompras = historicoCompras;
        this.cpf = cpf;
        this.pedidos = pedidos;
        
    }
}
