/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.entity;

/**
 *
 * @author Rafael
 */
public class Funcionario extends Pessoa{

    public Funcionario(String senha, String cargo, float salario) {
        this.senha = senha;
        this.cargo = cargo;
        this.salario = salario;
    }
    
     public Funcionario(String nome, String sonbrenome, String cpf, String telefone, String celular, String email, String rua, int numero, String estado, String cidade, String cep) {
        super(nome, sonbrenome, cpf, telefone, celular, email, rua, numero, estado, cidade, cep);
     }
    private String senha;
    private String cargo;
    private float salario;

    public String getCargo() {
        return cargo;
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
    
   

