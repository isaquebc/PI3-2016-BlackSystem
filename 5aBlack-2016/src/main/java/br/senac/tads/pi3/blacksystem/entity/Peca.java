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
public class Peca {
    
    private Integer id;
    private String descricao;
    private int qdt;
    private String tipoPeca;
    private String cor;
    private String tipoTecido;
    private Integer idPedido;
    private Integer idServico;

    public Peca() {
    }

    public Peca(String descricao, int qdt, String tipoPeca, String cor, String tipoTecido) {
        this.descricao = descricao;
        this.qdt = qdt;
        this.tipoPeca = tipoPeca;
        this.cor = cor;
        this.tipoTecido = tipoTecido;
    }    

    public Integer getId() {
        return id;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public Integer getIdServico() {
        return idServico;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQdt() {
        return qdt;
    }

    public void setQdt(int qdt) {
        this.qdt = qdt;
    }

    public String getTipoPeca() {
        return tipoPeca;
    }

    public void setTipoPeca(String tipoPeca) {
        this.tipoPeca = tipoPeca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipoTecido() {
        return tipoTecido;
    }

    public void setTipoTecido(String tipoTecido) {
        this.tipoTecido = tipoTecido;
    }
    
    
    
}
