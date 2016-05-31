/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.entity;

import java.sql.Date;

/**
 *
 * @author Rafael
 */
public class Funcionario extends Pessoa{

    String senha="";
    private String cargo="";
    private int filial;
    private String dataContratacao="";
    private double salario=0;
    public Endereco endereco = new Endereco();
    
    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getFilial() {
        return filial;
    }

    public void setFilial(int filial) {
        this.filial = filial;
    }

    public String getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    private String dataNascimento;

    public Funcionario(String cargo, int filial, String dataContratacao, String dataNascimento, int id, String nome, String sonbrenome, String cpf, String telefone, String celular, String email, String rua, int numero, String estado, String cidade, String cep) {
        super(id, nome, sonbrenome, cpf, telefone, celular, email, rua, numero, estado, cidade, cep);
        this.cargo = cargo;
        this.filial = filial;
        this.dataContratacao = dataContratacao;
        this.dataNascimento = dataNascimento;
    }

    public Funcionario(String cargo, int filial, String dataContratacao, String dataNascimento) {
        this.cargo = cargo;
        this.filial = filial;
        this.dataContratacao = dataContratacao;
        this.dataNascimento = dataNascimento;
    }
    
    public Funcionario() {
    }

    
    
    
   
    }
    
   

