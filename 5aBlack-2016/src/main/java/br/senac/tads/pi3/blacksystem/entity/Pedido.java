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

    private int idPedido;
    private String status;
    private Date dataEntrada;
    private String dataSaida;
    
    public Pedido(String tipoPeca, String status, String tipoTecido, Date dataEntrada, String dataSaida, String tipoLavagem, String qtd, String cor, Servico servico) {
        this.status = status;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Metodos Get e Set.">
    
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pedido() {
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setIdPedido(String listarCharado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }// </editor-fold>
}
