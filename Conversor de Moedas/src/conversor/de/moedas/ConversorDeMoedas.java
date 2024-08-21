/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor.de.moedas;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 
 * @author ANTONIO MILTON
 */
public class ConversorDeMoedas extends JFrame {

    private static final long serialVersionUID = 1L;

        private final JTextField txt; 
        private final JLabel resultado; //lbl resultado
        private final JComboBox  Combo;
        
   
    @SuppressWarnings("unchecked")
     public ConversorDeMoedas(){
         
         
         
         JFrame frame = new JFrame("Conversor de Moedas");
         frame.setSize(500, 500);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLocationRelativeTo(null);
         
         JPanel panel = new JPanel();
         panel.setLayout(new GridLayout(8, 1));
        
        
         
         JLabel titulo = new JLabel("Conversor de Moedas");
         titulo.setHorizontalAlignment(SwingConstants.CENTER);
         titulo.setFont(new Font("Arial", Font.BOLD, 23));
         panel.add(titulo);
         
       
         
         JLabel lblValor = new JLabel("Informe o valor em Meticas:");
       
         txt = new JTextField(30);
         txt.setBounds(50,50, 50, 50);
         panel.add(lblValor);
         panel.add(txt);
         
         JLabel lblmoeda = new JLabel("Selecione a moeda");
         panel.add(lblmoeda);
         
         String[] item = new String [3];
         item[0]= "Euro";
         item[1]= "Dolar";
         item[2]= "Rand";
         Combo = new JComboBox (item);
         panel.add(Combo);
         
         
         JButton btConverter = new JButton("Converter");
        btConverter.addActionListener((ActionEvent e)->{
            btConverter();
        });
         
        panel.add(btConverter);
         
         
         
         JButton btLimpar = new JButton("Limpar");
        btLimpar.addActionListener((ActionEvent e) -> {
            btLimpar();
        });
        panel.add(btLimpar);
        
        
        
        resultado = new JLabel();
        panel.add(resultado);
        
         
       frame.add(panel);
        frame.setVisible(true);
        setup();
         
     }
     
     private void setup(){
         txt.setEditable(true);
         txt.setText("Em Meticais");
         resultado.setText("");
         
     }
     
     private void btLimpar() {
         txt.setText("");
     }
     
     private void btConverter(){
        // DecimalFormat decimalFormat= new DecimalFormat("##.##");
         
         String valor=txt.getText();
         
         try{
             if(txt.getText().isEmpty()){
                 JOptionPane.showMessageDialog(null,"Digite a moeda");
             }else if("Euro".equals(Combo.getSelectedItem(). toString())){
                 double converter= Double.parseDouble(valor);
                 double resposta= converter/70.48;
                 
                 resultado.setText("Resultado:  " + (resposta) + " Euros");
                 
             } else if("Dolar".equals(Combo.getSelectedItem(). toString())){
                 double converter= Double.parseDouble(valor);
                 double resposta =converter/64.53;
                 
                 resultado.setText("Resultado:  "+ (resposta) + " Dolares");
             } else if("Rand".equals(Combo.getSelectedItem(). toString())){
                 double converter= Double.parseDouble(valor);
                 double resposta = converter/3.47;
                 
                 resultado.setText("Resultado:  "+ (resposta) + " rands");
             }
            
             
         }catch(Exception e){
             JOptionPane.showMessageDialog(this, "Ocorreu um Erro"+ e.getMessage() );
         }
     }
     
    
    public static void main(String[] args) {
        // TODO code application logic here
        ConversorDeMoedas conversorDeMoedas = new  ConversorDeMoedas();
    }
    
}
