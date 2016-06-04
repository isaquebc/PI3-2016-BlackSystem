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
public class TipoProduto {

    private int idTipo;
    private String nome;
    private String descricao;

    public TipoProduto() {
    }

    public TipoProduto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    // <editor-fold defaultstate="collapsed" desc="Metodos Get e Set.">
    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }// </editor-fold>
}
