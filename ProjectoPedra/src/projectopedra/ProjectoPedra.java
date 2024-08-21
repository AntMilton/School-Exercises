/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectopedra;

import java.lang.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author ANTONIO MILTON
 */
public class ProjectoPedra implements ActionListener{

    private final JRadioButton rb1;
    private final  JRadioButton rb2;
    private final  JRadioButton rb3;
   // private int rd;
   private final JLabel  lblAdv;
  // private final JButton btEscolher;
    
        ProjectoPedra(){
           
           JFrame frame= new JFrame("Programa Papel");
           frame.setSize(300,300);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setLocationRelativeTo(null);
           
           JPanel panel = new JPanel();
           panel.setLayout(new GridLayout(7,2));
           
           JLabel lbl = new JLabel("Escolha entre Pedra, Papel e Tesoura");
           panel.add(lbl);
           
           rb1= new JRadioButton("Pedra");
           rb2= new JRadioButton("Papel");
           rb3= new JRadioButton("Tesoura");
           
          
           
           ButtonGroup bg = new ButtonGroup();
           bg.add(rb1);
           bg.add(rb2);
           bg.add(rb3);
           
           panel.add(rb1);
           panel.add(rb2);
           panel.add(rb3);
           
          JButton  btEscolher= new JButton("Jogar!");
          btEscolher.addActionListener(this);
               
               
          
           panel.add(btEscolher);
           
           lblAdv = new JLabel();
           panel.add(lblAdv);
           
           
           frame.add(panel);
           frame.setVisible(true);
           setup();
            
           
        }
        
      private void setup(){
         
          lblAdv.setText("");
          
      }
      
      public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
      
       
    @Override
     public void actionPerformed(ActionEvent e){
       if (e.getActionCommand().equals("Jogar!")) {
            int escolhaUsuario = -1;
            if (rb1.isSelected()) {
                escolhaUsuario = 0;
            } else if (rb2.isSelected()) {
                escolhaUsuario = 1;
            } else if (rb3.isSelected()) {
                escolhaUsuario = 2;
            }

            if (escolhaUsuario != -1) {
                int X = randInt(0, 2);
                String resultado = determinarResultado(escolhaUsuario, X);
                lblAdv.setText(resultado);
            } else {
                lblAdv.setText("Por favor, escolha uma opção!");
            }
        }
    }

    private String determinarResultado(int escolhaUsuario, int X) {
        if (escolhaUsuario == X) {
            return "Empate!";
        } else if ((escolhaUsuario == 0 && X == 2) ||
                   (escolhaUsuario == 1 && X == 0) ||
                   (escolhaUsuario == 2 && X == 1)) {
            return "Você ganhou!";
        } else {
            return "Computador ganhou!";
        }
    }

 
    public static void main(String[] args) {
       new ProjectoPedra();
    }
    
}
