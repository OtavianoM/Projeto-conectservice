/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.PrestadorServico;


/**
 *
 * @authores Amanda, Cristovão, Dinah, Felipe, Marcelo e Otaviano 
 */
public class CadastroPrestador {
    Connection con;

    public CadastroPrestador() {
        con = ConnectionFactory.getConnection();
    }

    public void create(PrestadorServico use) {
        // nao pegando o erro pode ser o nome da tabela

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO prestador_servico  (nome, cnpj, login, senha, atuacao,valor, prestado_servico) VALUES(?,?,?,?,?,?,?)");
            //insert into "nome da tabela"
            stmt.setString(1, use.getNome());
            stmt.setString(2, use.getCnpj());
            stmt.setString(3, use.getLoginprestador());
            stmt.setString(4, use.getSenhaprestador());
            stmt.setString(5, use.getAtuacao());
            stmt.setString(6, use.getValor());
            stmt.setString(7, use.getPrestador());
            

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}

