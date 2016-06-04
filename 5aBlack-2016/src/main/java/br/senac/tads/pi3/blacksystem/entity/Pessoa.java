/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.entity;

import static java.sql.Types.NULL;
import java.util.Date;
import java.util.InputMismatchException;

/**
 *
 * @author Rafael
 */
public abstract class Pessoa {

    private int id;
    private String nome = "";
    private String sobrenome = "";
    private String cpf = "";
    private String telefone = "";
    private String celular = "";
    private String email = "";
    private String rua = "";
    private int numero = 0;
    private String estado = "";
    private String cidade = "";
    private String cep = "";
    private Date nasc = null;
    private String status = "";
    private String sexo = "";
    private Date dtCadastro = null;

    public Pessoa() {

    }

    public void retiraMascara() {
        this.cpf = this.cpf.replace(".", "");
        this.cpf = this.cpf.replace("-", "");
    }

    // <editor-fold defaultstate="collapsed" desc="Metodos Get e Set.">
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
        retiraMascara();
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Date getNasc() {
        return nasc;
    }

    public void setNasc(Date nasc) {
        this.nasc = nasc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }// </editor-fold>

    public boolean isCpf() {

        if (this.cpf.equals("00000000000") || this.cpf.equals("11111111111")
                || this.cpf.equals("22222222222") || this.cpf.equals("33333333333")
                || this.cpf.equals("44444444444") || this.cpf.equals("55555555555")
                || this.cpf.equals("66666666666") || this.cpf.equals("77777777777")
                || this.cpf.equals("88888888888") || this.cpf.equals("99999999999")
                || (this.cpf.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
// Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
// converte o i-esimo caractere do CPF em um numero:
// por exemplo, transforma o caractere '0' no inteiro 0         
// (48 eh a posicao de '0' na tabela ASCII)         
                num = (int) (this.cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }
// Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (this.cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

// Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == this.cpf.charAt(9)) && (dig11 == this.cpf.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

}
