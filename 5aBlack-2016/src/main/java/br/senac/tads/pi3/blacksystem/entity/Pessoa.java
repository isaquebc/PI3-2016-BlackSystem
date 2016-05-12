/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.entity;

import java.sql.Date;
import static java.sql.Types.NULL;

/**
 *
 * @author Rafael
 */
public abstract class Pessoa {
    

    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private String celular;
    private String email;
    private String rua;
    private int numero; 
    private String estado;
    private String cidade;
    private String cep;
    private Date nasc;
    private String status;

    public Pessoa(String nome, String sonbrenome, String cpf, String telefone, String celular, String email, String rua, int numero, String estado, String cidade, String cep) {
        this.nome = nome;
        this.sobrenome = sonbrenome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.rua = rua;
        this.numero = numero;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
    }

    public Pessoa() {
        this.nome = "";
        this.sobrenome = "";
        this.cpf = "";
        this.telefone = "";
        this.celular = "";
        this.email = "";
        this.rua = "";
        this.numero = 0;
        this.estado = "";
        this.cidade = "";
        this.cep = "";
        this.nasc = null;
        this.status= "";
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    public Date getNasc() {
        return nasc;
    }

    public void setNasc(Date nasc) {
        this.nasc = nasc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
