/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesquiemail;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ANTONIO MILTON
 */
public class PesquiEmail extends JFrame{

  
    private JTextField txt;
    private JButton JBPesquisar;
    private JButton JBCancelar;
    
    
    PesquiEmail(){
         JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2) );
        
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JMenuBar menuBar = new JMenuBar();
        JMenu arquivoMenu = new JMenu("Arquivo");
        JMenu editarMenu = new JMenu("Editar");
        JMenu VisualizarMenu = new JMenu("Visualizar");
        menuBar.add(arquivoMenu);
        menuBar.add(editarMenu);
        menuBar.add(VisualizarMenu);
        setJMenuBar(menuBar);
        
        
       
        
        JLabel lblEmail= new JLabel("Email");
        
        panel.add(lblEmail);
        
        txt = new JTextField();
        panel. add(txt);
        
        JButton btPesquisar = new JButton("Pesquisar");
        //btPesquisar.setLayout();
        btPesquisar.addActionListener((ActionEvent e) -> {
            JBPesquisar();
        });
        
        panel.add(btPesquisar);
        
        
        
        JButton btCancelar = new JButton("Cancelar");
        btCancelar.addActionListener((ActionEvent e) -> {
            JBCancelar();
        });
                
        panel.add(btCancelar);
        add(panel);
        setVisible(true);
   
    }    
    
    
    private void  JBPesquisar(){
        
        String Email=txt.getText();
       
        try{ 
             if(Email.contains("@")){
          JOptionPane.showMessageDialog(null,"Email Valido" );  
        }else{
            JOptionPane.showMessageDialog(null,"Email Invalido");
        }
        }catch(HeadlessException e) {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro"+ e.getMessage());
        }
       
        
    }
    
    private void JBCancelar(){
        System.exit(0);
    }
    
    public static void main(String[] args) {
      
        new PesquiEmail();
    }
    
}
