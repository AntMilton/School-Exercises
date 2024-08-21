/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moedas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
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
public class Moedas {

    private final JLabel resultado;
    private final JTextField txt;
    
        public Moedas(){
           
            JFrame frame = new JFrame("Conversor de Moedas");
            frame.setSize(400,400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JPanel panel = new JPanel ();
            panel.setLayout(new GridLayout(8,2));
            
            JLabel lblTitulo= new JLabel("Digite o valor em Meticais");
            panel.add(lblTitulo);
            
            txt = new JTextField(10);
            panel.add(txt);
            
            JButton btConverter= new JButton("Converter");
            btConverter.addActionListener((ActionEvent e)->{
            Converter();
        });
            panel.add(btConverter);
            
            resultado = new JLabel();
            panel.add(resultado);
            
            frame.add(panel);
            frame.setVisible(true);
            setup();
        }
        
        private void setup(){
            
            txt.setEditable(true);
            txt.setText("");
            
        }
    
        private void Converter(){
           String valor= txt.getText();
          
            
            
            
            try{
                if(txt.getText(). isEmpty()){
                    JOptionPane.showMessageDialog(null,"Digite a moeda");
                }else{
                 double converter= Double.parseDouble(valor);
                 double resposta =converter/63;
                 
                 resultado.setText("Resultado:  "+ (resposta) + " Dolares");
                
            }
            

        }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Ocoreu um erro em : "+ e.getMessage() );
                    }
        }
    
    
    
    
    
    
    
        
    
    
    
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        new Moedas();
    }
    
}
