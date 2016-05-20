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

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }
    private String tipoPeca;
    private String cor;
    private String tipoTecido;
    private Integer idPedido;
    private String nomeServico;
    private int idServico;

    public Peca() {
    }

    public Peca(String descricao, int qdt, String tipoPeca, String cor, String tipoTecido, int idServico) {
        this.descricao = descricao;
        this.qdt = qdt;
        this.tipoPeca = tipoPeca;
        this.cor = cor;
        this.tipoTecido = tipoTecido;
        this.idServico = idServico;
    }    

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public int getIdServico() {
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
