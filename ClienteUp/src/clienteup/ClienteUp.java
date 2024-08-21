/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteup;

import conexao.conexao;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ANTONIO MILTON
 */
public class ClienteUp {

    private final JTextField txtId;
    private final JTextField txtNome;
    private final JTextField txtEmail;
    
    
    
   public ClienteUp(){
        
        
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,450);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9,3));
        
        JLabel lblId= new JLabel("Id");
        panel.add(lblId);
        
        txtId= new JTextField();
        panel.add(txtId);
        
        JLabel lblNome = new JLabel("Nome: ");
        panel.add(lblNome);
        
         txtNome= new JTextField();
        panel.add(txtNome);
        
        JLabel lblEmail = new JLabel("Email");
        panel.add(lblEmail);
        
         txtEmail = new JTextField();
        panel.add(txtEmail);
        
        JButton btInserir = new JButton ("Inserir");
        btInserir.addActionListener((ActionEvent e)->{
            Inserir();
        });
        
        panel.add(btInserir);
        
        JButton btUpdate = new JButton("Actualizar");
        btUpdate.addActionListener((ActionEvent e)->{
            Actualizar();
        });
        
        panel.add(btUpdate);
        
        JButton btExcluir = new JButton("Excluir");
        btExcluir.addActionListener((ActionEvent e)->{
            Excluir();
        });
        panel.add(btExcluir);
        
        frame.add(panel);
        frame.setVisible(true);
        setup();
        
   
    }
    
    private void setup(){
       txtId.setEditable(true);
      txtId.setText(""); 
      txtNome.setEditable(true);
      txtNome.setText("");
      txtEmail.setEditable(true);
      txtEmail.setText("");
    }
    
    private void Inserir(){
       String id= txtId.getText();
        String Nome= txtNome.getText();
        String Email= txtEmail.getText(); 
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = conexao.obterConexao(); 
            Statement st= conn.createStatement();
            String sql = "INSERT INTO cliente VALUES(?,?,?) ";
            
            PreparedStatement pstm= conn.prepareStatement(sql); 
            pstm.setString(1, id);
            pstm.setString(2,Nome);
            pstm.setString(3,Email);
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Cadastro Efectuado com SUCESSO" );
            
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro em :"+ e.getMessage());
        }
    }
    
    private void Actualizar(){
            String id = txtId.getText();
            String nome = txtNome.getText();
            String email = txtEmail.getText();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = conexao.obterConexao();
            String sql = "UPDATE cliente SET id =?, nome =?, email =? WHERE id = " + id;
            PreparedStatement pstm = conn.prepareStatement(sql);
             pstm.setString(1, id);
            pstm.setString(2, nome);
            pstm.setString(3, email);
            
           
       int linhasAfetadas = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualização dos dados efetuada com SUCESSO!! Linhas afetadas: " + linhasAfetadas);
            pstm.close();
            conn.close();
        
        } 
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocorreu um erro em : "+ e.getMessage());
        }
            
    }
    private void Excluir(){
         String Id= txtId.getText();
           try{
           Class.forName("com.mysql.jdbc.Driver");
                try (Connection conn = conexao.obterConexao()) {
                    Statement st = conn.createStatement();
                    String sql = "DELETE FROM cliente WHERE id=" + Id;
                    
         
                    PreparedStatement pstm = conn.prepareStatement(sql);
                    
                    pstm.executeUpdate();
                    conn.close();
                    
                    JOptionPane.showMessageDialog(null, " CADASTRO eliminado com SUCESSO!! ");
                }
        
            
           
           
            
            
            
          } catch(Exception e){
              JOptionPane.showMessageDialog(null,"Ocorreu um erro em " + e);
          }
           
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        new ClienteUp();
    }}

   
    

