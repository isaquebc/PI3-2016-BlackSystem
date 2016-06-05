/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.entity;

/**
 *
 * @author Miqueas Santos
 */
public class MovimentoProduto {
    
    private String descricao;
    private String data;
    private String produto;
    private float qtd;
    private String funcionaro;
    private String filial;
    private int idProduto;
    private int idFuncionario;
    private int idFilial;
    private float qtdAtual;
    
    // <editor-fold defaultstate="collapsed" desc="Metodos Get e Set.">

    public void setQtdAtual(float qtdAtual) {
        this.qtdAtual = qtdAtual;
    }

    public float getQtdAtual() {
        return qtdAtual;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public float getQtd() {
        return qtd;
    }

    public void setQtd(float qtd) {
        this.qtd = qtd;
    }

    public String getFuncionario() {
        return funcionaro;
    }

    public void setFuncionario(String funcionaro) {
        this.funcionaro = funcionaro;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionaro(int idFuncionaro) {
        this.idFuncionario = idFuncionaro;
    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }// </editor-fold>
    
}
