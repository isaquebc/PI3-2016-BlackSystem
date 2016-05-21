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

    private String senha;
    private String cargo;
    private String filial;
    private String dataContratacao;
    private String dataNascimento;

    
    
     public Funcionario(String senha, String cargo, float salario) {
        this.senha = senha;
        this.cargo = cargo;
        this.salario = salario;
    }
    
     public Funcionario(int id, String nome, String sonbrenome, String cpf, String telefone, String celular, String email, String rua, int numero, String estado, String cidade, String cep) {
        super(id, nome, sonbrenome, cpf, telefone, celular, email, rua, numero, estado, cidade, cep);
     }
    
    
    
    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    private float salario;

    public Funcionario() {
    }
     
    public String getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getCargo() {
        return cargo;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

   
    }
    
   

