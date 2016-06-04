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
    private String dtRetirada;
    private String qdt;
    private String tipoPeca;
    private String cor;
    private String tipoTecido;
    private String idPedido;
    private String nomeServico;
    private String idServico;

    public Peca() {
    }

    public Peca(String descricao, String qdt, String tipoPeca, String cor, String tipoTecido, String idServico) {
        this.descricao = descricao;
        this.qdt = qdt;
        this.tipoPeca = tipoPeca;
        this.cor = cor;
        this.tipoTecido = tipoTecido;
        this.idServico = idServico;
    } 

    // <editor-fold defaultstate="collapsed" desc="Metodos Get e Set.">
    
    public String getDtRetirada() {
        return dtRetirada;
    }

    public void setDtRetirada(String dtRetirada) {
        this.dtRetirada = dtRetirada;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }
    
    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }  

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdServico(String idServico) {
        this.idServico = idServico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public Integer getId() {
        return id;
    }

    public String getIdServico() {
        return idServico;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getQdt() {
        return qdt;
    }

    public void setQdt(String qdt) {
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
    }// </editor-fold>    
}
