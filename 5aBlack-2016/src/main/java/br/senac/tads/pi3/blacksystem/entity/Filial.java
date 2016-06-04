/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.entity;

/**
 *
 * @author Isaque
 */
public class Filial {
    
    private String idFilial;
    private String nome;
    private String endereco;
    private String cidade;
    private String tel;
    private String cep;
    private String estado;

    public Filial() {
    }

    public Filial(String nome, String endereco, String cidade, String tel, String cep, String estado) {
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.tel = tel;
        this.cep = cep;
        this.estado = estado;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Metodos Get e Set.">
    
    public String getIdFilial() {
        return idFilial;
    }  
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setIdFilial(String idFilial) {
        this.idFilial = idFilial;
    }// </editor-fold>    
}
