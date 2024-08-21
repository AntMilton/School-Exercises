/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import conexao.conexao;
import Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ANTONIO MILTON
 */
public class ClienteController {
    
      public void inserirCliente(int id, String nome, String email) {
          
          
        try {
             Class.forName("com.mysql.jdbc.Driver");
            Connection conn = conexao.obterConexao(); 
            Statement st= conn.createStatement();
            String sql = "INSERT INTO cliente VALUES(?,?,?) ";
            
            PreparedStatement pstm= conn.prepareStatement(sql); 
            pstm.setInt(1, id);
            pstm.setString(2,nome);
            pstm.setString(3,email);
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Cadastro Efectuado com SUCESSO" );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro em: " + e.getMessage());
        }
    }

    public void atualizarCliente(int id, String nome, String email) {
        try {
           
             Class.forName("com.mysql.jdbc.Driver");
            Connection conn = conexao.obterConexao();
            String sql = "UPDATE cliente SET id =?, nome =?, email =? WHERE id = " + id;
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.setString(2, nome);
            pstm.setString(3, email);
            
           
       int linhasAfetadas = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualização dos dados efetuada com SUCESSO!! Linhas afetadas: " + linhasAfetadas);
            pstm.close();
            conn.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro em: " + e.getMessage());
        }
    }

    public void excluirCliente(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = conexao.obterConexao();
           Statement st = conn.createStatement();
            String sql = "DELETE FROM cliente WHERE id=" + id;
         
                    PreparedStatement pstm = conn.prepareStatement(sql);
                    
                    pstm.executeUpdate();
                    conn.close();
                    
                    JOptionPane.showMessageDialog(null, " CADASTRO eliminado com SUCESSO!! ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro em: " + e.getMessage());
        }
    }
}
