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
public class FormasPagamentos {
    private int codpagamento;
    private String formasPagamento;
    private String valor;
    private String cnpj;
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

 
    

    public int getCodpagamento() {
        return codpagamento;
    }

    public void setCodpagamento(int codpagamento) {
        this.codpagamento = codpagamento;
    }

    public String getFormasPagamento() {
        return formasPagamento;
    }

    public void setFormasPagamento(String formasPagamento) {
        this.formasPagamento = formasPagamento;
    }
    
    
}
