/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.entity;

import java.sql.Date;

/**
 *
 * @author Isaque
 */
public class Chamado {
    
    private Integer idChamado;
    private String descricao;
    private String status;
    private Date dataAbertura;
    private String tipoSolicitacao;
    private Integer idFuncionario;

    public Chamado() {
    }

    public Chamado(String descricao, String status, Date dataAbertura, String tipoSolicitacao) {
        this.descricao = descricao;
        this.status = status;
        this.dataAbertura = dataAbertura;
        this.tipoSolicitacao = tipoSolicitacao;
    }
    
    public Integer getIdChamado() {
        return idChamado;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getTipoSolicitacao() {
        return tipoSolicitacao;
    }

    public void setTipoSolicitacao(String tipoSolicitacao) {
        this.tipoSolicitacao = tipoSolicitacao;
    }
    
    
    
}
