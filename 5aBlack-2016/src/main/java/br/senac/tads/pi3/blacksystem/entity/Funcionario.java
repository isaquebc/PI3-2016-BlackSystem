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
    
    
    private String hashSenha;
    private String cargo="";
    private int filial;
    private String dataContratacao="";
    private double salario=0;
    private Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public String getHashSenha() {
        return hashSenha;
    }

    public void setHashSenha(String senha) {
        this.hashSenha = senha;
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
    
    public Erro validar(Pessoa pessoa){
        ValidacaoFactory n = new ValidacaoFactory();
        return  n.validarFuncionario((Funcionario) pessoa);
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    private String dataNascimento;

    public Funcionario(String cargo, int filial, String dataContratacao, String dataNascimento, int id, String nome, String sonbrenome, String cpf, String telefone, String celular, String email, String rua, int numero, String estado, String cidade, String cep) {
        super();
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
        this.endereco = new Endereco();
    }

    
    
    
   
    }
    
   

