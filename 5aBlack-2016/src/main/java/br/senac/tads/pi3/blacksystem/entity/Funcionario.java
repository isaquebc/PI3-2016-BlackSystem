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
public class Funcionario extends Pessoa {

    private String hashSenha;
    private String cargo = "";
    private int filial;
    private Date dataContratacao;
    private double salario = 0;
    private String[] papeis;
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

    public String[] getPapeis() {
        return this.papeis;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
        this.papeis = papeis(cargo);
    }

    public int getFilial() {
        return filial;
    }

    public void setFilial(int filial) {
        this.filial = filial;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public Erro validar(Pessoa pessoa) {
        ValidacaoFactory n = new ValidacaoFactory();
        return n.validarFuncionario((Funcionario) pessoa);
    }

    public String[] papeis(String cargo) {

        switch (cargo) {

            case "BACKOFFICE":
                String papeis[] = {"BASICO", "INTERMEDIARIO"};
                return papeis;
            case "ATENDIMENTO":
                String atendimento[] = {"BASICO", "VENDEDOR"};
                return atendimento;
            case "SUPORTETECNICO":
                String suporteTI[] = {"BASICO", "INTERMEDIARIO", "VENDEDOR", "GERENTE"};
                return suporteTI;
            case "GERENTETI":
                String gerenteTi[] = {"BASICO", "INTERMEDIARIO", "VENDEDOR", "GERENTE"};
                return gerenteTi;
            case "GERENTEATENDIMENTO":
                String gerenteAtendimento[] = {"BASICO", "VENDEDOR", "GERENTE"};
                return gerenteAtendimento;
            case "GERENTEPRODUTO":
                String gerenteProuto[] = {"BASICO", "INTERMEDIARIO", "GERENTE"};
                return gerenteProuto;
            case "DIRETOR":
                String gerenteDiretor[] = {"BASICO", "INTERMEDIARIO", "VENDEDOR", "GERENTE"};
                return gerenteDiretor;
        }
        return null;
    }

    public Funcionario(String cargo, int filial, Date dataContratacao, String dataNascimento, int id, String nome, String sonbrenome, String cpf, String telefone, String celular, String email, String rua, int numero, String estado, String cidade, String cep) {
        super();
        this.cargo = cargo;
        this.filial = filial;
        this.dataContratacao = dataContratacao;
        this.dataNascimento = dataNascimento;
    }

    public Funcionario(String cargo, int filial, Date dataContratacao, String dataNascimento) {
        this.cargo = cargo;
        this.filial = filial;
        this.dataContratacao = dataContratacao;
        this.dataNascimento = dataNascimento;
    }

    public Funcionario() {
        this.endereco = new Endereco();
    }

}
