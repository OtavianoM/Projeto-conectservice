/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @authores Amanda, Cristovão, Dinah, Felipe, Marcelo e Otaviano 
 */
public class PrestadorServico {
    private String nome;
    private String cnpj;
    private String loginprestador;
    private String senhaprestador;
    private String atuacao;
    private String prestador;
    private String valor;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getPrestador() {
        return prestador;
    }

    public void setPrestador(String prestador) {
        this.prestador = prestador;
    }

   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getLoginprestador() {
        return loginprestador;
    }

    public void setLoginprestador(String login) {
        this.loginprestador = login;
    }

    public String getSenhaprestador() {
        return senhaprestador;
    }

    public void setSenhaprestador(String senha) {
        this.senhaprestador = senha;
    }

    public String getAtuacao() {
        return atuacao;
    }

    public void setAtuacao(String atuacao) {
        this.atuacao = atuacao;
    }

   
    
    
    
}
