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
    private String idCPF;
    private String numero;

    // <editor-fold defaultstate="collapsed" desc="Metodos Get e Set.">

    
    public String getIdCPF() {
        return idCPF;
    }

    public void setIdCPF(String idCPF) {
        this.idCPF = idCPF;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
    }// </editor-fold>
}

