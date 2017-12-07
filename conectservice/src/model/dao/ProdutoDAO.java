/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.FormasPagamentos;
import model.bean.PrestadorServico;

/**
 *
 * @authores Amanda, Cristovão, Dinah, Felipe, Marcelo e Otaviano 
 */
public class ProdutoDAO {

    Connection con;
    
    public ProdutoDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    
    public void create(FormasPagamentos produto) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO pagamento (formas_pagamento,valor,cnpj, cpf)VALUES(?,?,?,?)");
           stmt.setString(1, produto.getFormasPagamento());
           stmt.setString(2, produto.getValor()); // testar operacao aqui
           stmt.setString(3, produto.getCnpj());
           stmt.setString(4, produto.getCpf());
            stmt.executeUpdate();
            

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }



    public List<PrestadorServico> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<PrestadorServico> servicos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM prestador_servico");
            rs = stmt.executeQuery();

            while (rs.next()) {

               PrestadorServico produto = new PrestadorServico();

                produto.setNome(rs.getString("nome"));
                produto.setCnpj(rs.getString("cnpj"));
                produto.setAtuacao(rs.getString("atuacao"));
                produto.setValor(rs.getString("valor"));
                servicos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return servicos;

    }
    public List<PrestadorServico> readForDesc(String desc) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<PrestadorServico> servicos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM prestador_servico where atuacao LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                PrestadorServico produto = new PrestadorServico();

                produto.setNome(rs.getString("nome"));
                produto.setCnpj(rs.getString("cnpj"));
                produto.setAtuacao(rs.getString("atuacao"));
                produto.setValor(rs.getString("valor"));
                servicos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return servicos;

    }
    
    
/*
    public void update(PrestadorServico p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE produto SET descricao = ? ,qtd = ?,preco = ? WHERE id = ?");
            stmt.setString(1, p.getDescricao());
            stmt.setInt(2, p.getQtd());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    */
    
    
    /*
    public void delete(PrestadorServico p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM produto WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }


    } 
 */  
    
}
