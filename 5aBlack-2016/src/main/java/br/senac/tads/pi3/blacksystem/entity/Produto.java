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
public class Produto {
    private int idProduto;
    private String nome;
    private String validade;
    private String data;
    private int lote;
    private String status;
    private float qtdMin;
    private float qtdMax;
    private float qtdAtual;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getQtdMin() {
        return qtdMin;
    }

    public void setQtdMin(float qtdMin) {
        this.qtdMin = qtdMin;
    }

    public float getQtdMax() {
        return qtdMax;
    }

    public void setQtdMax(float qtdMax) {
        this.qtdMax = qtdMax;
    }

    public float getQtdAtual() {
        return qtdAtual;
    }

    public void setQtdAtual(float qtdAtual) {
        this.qtdAtual = qtdAtual;
    }
    
    
       
}
