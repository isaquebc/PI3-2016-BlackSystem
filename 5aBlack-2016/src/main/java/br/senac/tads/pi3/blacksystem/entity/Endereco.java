/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.entity;

import static java.sql.Types.INTEGER;

/**
 *
 * @author Isaque
 */
public class Endereco {
    private Integer id;
    private String endereco;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private Integer idCPF;
    private Integer numero;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    

    public Endereco(Integer idCPF) {
        this.idCPF = idCPF;
    }

    public Endereco() {
    }

    
    
    public Integer getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getIdCPF() {
        return idCPF;
    } 
    
}

