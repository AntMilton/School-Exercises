/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;

import Conexao.Conexao;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Cadastro extends JFrame {
    
       private final  JTextField txtID;
       private final  JTextField txtNome;
       private final  JTextField txtEmail;

       public  Cadastro(){
            JFrame frame = new JFrame("Cadastro Cliente");
            frame.setSize(300,350);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(11, 4));
            
            JLabel lblID = new JLabel("ID:");
            panel.add(lblID);
            
            txtID = new JTextField (4);
            panel.add(txtID);
            
            JLabel lblNome = new JLabel("Nome:");
            panel.add(lblNome);
            
             txtNome= new JTextField(50);
            panel.add(txtNome);
            
            JLabel lblEmail = new JLabel("Email");
            panel.add(lblEmail);
            
             txtEmail = new JTextField();
            panel.add(txtEmail);
            
            JButton btInserir = new JButton("Inserir");
            btInserir.addActionListener((ActionEvent e)->{
                try {
                    Inserir();
                } catch (Exception ex) {
                    Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
                }
       });
            panel.add(btInserir);
            
            JButton btExcluir = new JButton("Excluir");
            btExcluir.addActionListener((ActionEvent e) ->{
                Excluir();
            });
            
            panel.add(btExcluir);
            
            
            
            
            
            
            frame.add(panel);
            frame.setVisible(true);
            setup();
            
      
            
            
        }
       
       private void setup(){
           txtID.setEditable(true);
           txtID.setText("");
           txtNome.setEditable(true);
           txtNome.setText("");
           txtEmail.setEditable(true);
           txtEmail.setText("");
       }
       
       private void Inserir() throws Exception{
             String Id= txtID.getText();
            String Nome= txtNome.getText();
            String Email= txtEmail.getText();
           
           try{
           Class.forName("com.mysql.jdbc.Driver");
            Connection conn = Conexao.obterConexao();
            Statement st = conn.createStatement();
            String sql = "INSERT INTO cliente VALUES(?,?,?) ";
            
            
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, Id);
            pstm.setString(2,Nome );
            pstm.setString(3, Email);
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null," Cadastro Efectuado com SUCESSO ");
            
            
          } catch(Exception e){
              JOptionPane.showMessageDialog(null,"Ocorreu um erro em " + e);
          }
            
       }
       
       private void Excluir(){
           
            String Id= txtID.getText();
           try{
           Class.forName("com.mysql.jdbc.Driver");
                try (Connection conn = Conexao.obterConexao()) {
                    Statement st = conn.createStatement();
                    String sql = "DELETE FROM cliente WHERE id="+ Id;
                    
                    
                    
                    
                    PreparedStatement pstm = conn.prepareStatement(sql);
                    
                    pstm.executeUpdate();
                    conn.close();
                    
                    JOptionPane.showMessageDialog(null, " CADASTRO eliminado com SUCESSO!! ");
                }
         txtID.setText("");
            
           
           
            
            
            
          } catch(Exception e){
              JOptionPane.showMessageDialog(null,"Ocorreu um erro em " + e);
          }
           
       }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Cadastro();
    }
    
}
