/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planeta;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author ANTONIO MILTON
 */
@SuppressWarnings("serial")
public class Planeta extends JFrame{
    
        private final  JTextField txt;
       private final ButtonGroup bg;
    private final JRadioButton rb1; 
    private final JRadioButton rb2; 
    private final JRadioButton rb3; 
    private final JRadioButton rb4; 
          private final JRadioButton rb5; 
          private final JRadioButton rb6;
    
    
    public Planeta(){
        
        JFrame frame= new JFrame("Conversor de Peso");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 3));
        
        JLabel titulo = new JLabel("Conversor de Peso");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 23));
        panel.add(titulo);
        
        JLabel peso = new JLabel("Peso na terra (kg)");
        panel.add(peso);
        
        txt = new JTextField(20);
        panel.add(txt);
        
        JButton btCalcular= new JButton ("Calcular Peso"); 
        btCalcular.addActionListener((ActionEvent e) -> {
            calcular();
        });
        panel.add(btCalcular);
        
        
        JLabel texto= new JLabel("Selecione o Planeta: ");
        panel.add(texto);
        
        rb1= new JRadioButton("Mercurio");
         rb2= new JRadioButton("Venus");
          rb3= new JRadioButton("Marte");
           rb4= new JRadioButton("Jupiter");
            rb5= new JRadioButton("Saturno");
             rb6= new JRadioButton("Urano");
             
          bg= new ButtonGroup();
          bg.add(rb1);
          bg.add(rb2);
          bg.add(rb3);
          bg.add(rb4);
          bg.add(rb5);
          bg.add(rb6);
          
           panel.add(rb1);
          panel.add(rb2);
          panel.add(rb3);
          panel.add(rb4);
          panel.add(rb5);
          panel.add(rb6);
          
          
         
          
          frame.add(panel);
          frame.setVisible(true);
          receber();
       
        
    }
    
    private void receber(){
        txt.setEditable(true);
        txt.setText("");
    }
    
    private void calcular(){
        double valor= Double.parseDouble(txt.getText());
        
        if(txt.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o Campo");
        }else if(rb1.isSelected()){
            double resultado=((valor/10)*0.37);
          JOptionPane.showMessageDialog(null, "O seu peso em Mercurio é:  " + resultado + " Kg");  
          
        } else if(rb2.isSelected()){
            double resultado=((valor/10)*0.88);
          JOptionPane.showMessageDialog(null, "O seu peso em Venus é :  " + resultado + " Kg"); 
        } else if(rb3.isSelected()){
            double resultado=((valor/10)*0.38);
          JOptionPane.showMessageDialog(null, "O seu peso em Marte é:  " + resultado + " Kg");
        } else if(rb4.isSelected()){
            double resultado=((valor/10)* 2.64);
          JOptionPane.showMessageDialog(null, "O seu peso em Jupiter é:  " + resultado + " Kg");
        } else if(rb5.isSelected()){
            double resultado=((valor/10)* 1.15);
          JOptionPane.showMessageDialog(null, "O seu peso em Saturno é:  " + resultado + " Kg");
        } else if(rb6.isSelected()){
            double resultado=((valor/10)* 1.17);
          JOptionPane.showMessageDialog(null, "O seu peso em Urano é:  " + resultado + " Kg");
        }
        
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        new Planeta();
    }
    
}
