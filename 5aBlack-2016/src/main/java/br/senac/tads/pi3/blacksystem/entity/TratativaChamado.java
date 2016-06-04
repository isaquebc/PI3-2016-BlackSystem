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
public class TratativaChamado {

    private Integer idTratativa;
    private Date dataFechamento;
    private String descricao;
    private Integer idChamado;
    private Integer idFuncionario;

    public TratativaChamado() {
    }

    public TratativaChamado(Date dataFechamento, String descricao) {
        this.dataFechamento = dataFechamento;
        this.descricao = descricao;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Metodos Get e Set.">

    public Integer getIdTratativa() {
        return idTratativa;
    }

    public Integer getIdChamado() {
        return idChamado;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }// </editor-fold>
}
