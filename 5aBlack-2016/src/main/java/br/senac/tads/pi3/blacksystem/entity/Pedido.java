/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.entity;

import java.util.Date;

/**
 *
 * @author Rafael
 */
public class Pedido {

    private long idPedido;

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }
    private String tipoPeca;
    private String status;
    private String tipoTecido;
    private Date dataEntrada;
    private Date dataSaida;
    private String tipoLavagem;
    private String qtd;
    private String cor;
    private Servico servico;

    public Pedido(String tipoPeca, String status, String tipoTecido, Date dataEntrada, Date dataSaida, String tipoLavagem, String qtd, String cor, Servico servico) {
        this.tipoPeca = tipoPeca;
        this.status = status;
        this.tipoTecido = tipoTecido;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.tipoLavagem = tipoLavagem;
        this.qtd = qtd;
        this.cor = cor;
        this.servico = servico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pedido() {
    }

    public String getTipoPeca() {
        return tipoPeca;
    }

    public void setTipoPeca(String tipoPeca) {
        this.tipoPeca = tipoPeca;
    }

    public String getTipoTecido() {
        return tipoTecido;
    }

    public void setTipoTecido(String tipoTecido) {
        this.tipoTecido = tipoTecido;
    }

    public String getTipoLavagem() {
        return tipoLavagem;
    }

    public void setTipoLavagem(String tipoLavagem) {
        this.tipoLavagem = tipoLavagem;
    }

    public String getQtd() {
        return qtd;
    }

    public void setQtd(String qtd) {
        this.qtd = qtd;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

}
